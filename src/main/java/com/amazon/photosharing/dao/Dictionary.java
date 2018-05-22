/*
 * Copyright 2010-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *
 */

package com.amazon.photosharing.dao;

import java.util.Locale;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "dictionary")
@Cacheable
@Cache(region = "dictionary", usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Dictionary {

	private DictionaryPK id;
	private String text;

	public Dictionary() {
	}

	public Dictionary(String p_key, Locale p_locale, String p_text) {
		setId(getKey(p_key, p_locale));
		setText(p_text);
	}

	@Id
	public DictionaryPK getId() {
		return id;
	}

	public void setId(DictionaryPK p_id) {
		this.id = p_id;
	}

	@Column(columnDefinition = "TEXT")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public static DictionaryPK getKey(String p_key, Locale p_locale) {
		return new DictionaryPK(p_key, p_locale);
	}
}
