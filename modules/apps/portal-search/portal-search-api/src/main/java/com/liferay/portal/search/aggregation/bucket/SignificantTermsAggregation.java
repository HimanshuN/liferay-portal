/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.search.aggregation.bucket;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.search.aggregation.FieldAggregation;
import com.liferay.portal.search.query.Query;
import com.liferay.portal.search.significance.SignificanceHeuristic;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface SignificantTermsAggregation extends FieldAggregation {

	public Query getBackgroundFilterQuery();

	public BucketCountThresholds getBucketCountThresholds();

	public String getExecutionHint();

	public IncludeExcludeClause getIncludeExcludeClause();

	public Long getMinDocCount();

	public Long getShardMinDocCount();

	public Integer getShardSize();

	public SignificanceHeuristic getSignificanceHeuristic();

	public Integer getSize();

	public void setBackgroundFilterQuery(Query backgroundFilterQuery);

	public void setBucketCountThresholds(
		BucketCountThresholds bucketCountThresholds);

	public void setExecutionHint(String executionHint);

	public void setIncludeExcludeClause(
		IncludeExcludeClause includeExcludeClause);

	public void setMinDocCount(Long minDocCount);

	public void setShardMinDocCount(Long shardMinDocCount);

	public void setShardSize(Integer shardSize);

	public void setSignificanceHeuristic(
		SignificanceHeuristic significanceHeuristic);

	public void setSize(Integer size);

}