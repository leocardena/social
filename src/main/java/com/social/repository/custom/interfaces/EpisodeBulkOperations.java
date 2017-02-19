package com.social.repository.custom.interfaces;

import java.util.Collection;
import com.social.domain.Episode;

public interface EpisodeBulkOperations {
	
	public <T extends Episode> Collection<T> bulkSave(Collection<T> entities);

}
