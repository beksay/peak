package org.peakcoin.service.impl;

import java.io.IOException;

import javax.activation.DataHandler;
import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.peakcoin.dao.AttachmentDao;
import org.peakcoin.dao.impl.AttachmentDaoImpl;
import org.peakcoin.domain.Attachment;
import org.peakcoin.dto.AttachmentBinaryDTO;
import org.peakcoin.dto.AttachmentDataSource;
import org.peakcoin.dto.IdentifyResponse;
import org.peakcoin.service.AttachmentService;
import org.peakcoin.soa.RepositoryService;
import org.peakcoin.soa.RepositoryServiceFactory;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Stateless
@Local(AttachmentService.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class AttachmentServiceImpl extends GenericServiceImpl<Attachment, Integer, AttachmentDao> implements AttachmentService {

	private RepositoryService service;
	
	@PostConstruct
	private void init(){
		try {
			service = RepositoryServiceFactory.getInstance().getService();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected AttachmentDao getDao() {
		return new AttachmentDaoImpl(em,se);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Attachment saveFromDTO(AttachmentBinaryDTO binary) throws IOException {
		binary.setName(binary.getAttachment().getRepositoryName());
		DataHandler handler = new DataHandler(new AttachmentDataSource(binary));
		IdentifyResponse response = service.save(binary.getAttachment().getFileName(), handler);
		binary.getAttachment().setRepositoryName(response.getChecksum());
		
		return persist(binary.getAttachment());
	}

}
