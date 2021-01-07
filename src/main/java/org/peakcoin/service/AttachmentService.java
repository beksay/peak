package org.peakcoin.service;

import java.io.IOException;

import javax.ejb.Local;

import org.peakcoin.domain.Attachment;
import org.peakcoin.dto.AttachmentBinaryDTO;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Local
public interface AttachmentService extends GenericService<Attachment, Integer> {
	
	Attachment saveFromDTO(AttachmentBinaryDTO binary) throws IOException;

}
