package org.peakcoin.service;

import javax.ejb.Local;

import org.peakcoin.domain.Feedback;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Local
public interface FeedbackService extends GenericService<Feedback, Integer> {

}
