// ***********************************************************************
// Copyright (c) 2015. ASA(ALT) SoSE Directorate
// All Rights Reserved.
// Permission to use, copy, modify, and distribute this software and
// its documentation for any purpose, without fee and without a signed
// licensing agreement, is hereby prohibited. Any unauthorized
// reproduction or distribution of this software, or any portion of it,
// may result in severe civil and criminal penalties, and will be
// prosecuted to the maximum extent possible under the law.
// ***********************************************************************

package sample.persistence.repo;

import java.util.List;

import javax.persistence.PersistenceUnit;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import sample.Global;
import sample.persistence.force.Platform;

@RepositoryRestResource
// @PersistenceUnit(name=Global.USER_SPECIFIC_DATA_QUALIFIER)
public interface PlatformRepository extends CrudRepository<Platform, Integer>
{
	@RestResource(path = "byPlatform")
	Platform findByPlatformId(@Param("platformId") long platformId);
	
	@RestResource(path = "byObject")
	Platform findByObjectId(@Param("objectId") String objectId);

	@RestResource(path = "byOrgCode")
	List<Platform> findByOrgCode(@Param("orgCode") int orgCode);
}