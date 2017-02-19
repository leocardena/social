package com.social.repository.custom.interfaces;

import java.util.Collection;
import com.social.domain.Season;

public interface SeasonBulkOperations {
	
	public <T extends Season> Collection<T> bulkSave(Collection<T> entities);

}
