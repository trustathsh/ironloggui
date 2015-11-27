/*
 * #%L
 * =====================================================
 *   _____                _     ____  _   _       _   _
 *  |_   _|_ __ _   _ ___| |_  / __ \| | | | ___ | | | |
 *    | | | '__| | | / __| __|/ / _` | |_| |/ __|| |_| |
 *    | | | |  | |_| \__ \ |_| | (_| |  _  |\__ \|  _  |
 *    |_| |_|   \__,_|___/\__|\ \__,_|_| |_||___/|_| |_|
 *                             \____/
 * 
 * =====================================================
 * 
 * Hochschule Hannover
 * (University of Applied Sciences and Arts, Hannover)
 * Faculty IV, Dept. of Computer Science
 * Ricklinger Stadtweg 118, 30459 Hannover, Germany
 * 
 * Email: trust@f4-i.fh-hannover.de
 * Website: http://trust.f4.hs-hannover.de/
 * 
 * This file is part of ironloggui, version 0.0.1,
 * implemented by the Trust@HsH research group at the Hochschule Hannover.
 * %%
 * Copyright (C) 2015 Trust@HsH
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package de.hshannover.f4.trust.ironloggui;

import java.util.List;

import org.apache.log4j.Logger;

import de.hshannover.f4.trust.ironcommon.properties.Properties;
import de.hshannover.f4.trust.ironcommon.properties.PropertyException;

public final class Configuration {

	private static final Logger LOGGER = Logger.getLogger(Configuration.class.getName());

	private static final String FILENAME = "/config/configuration.yml";

	private static final String ROOTDIRFORSEARCH = "ironloggui.rootdir";
	private static final String SEARCHFORFILES = "ironloggui.searchfor";
	private static final String EXPLICITFILES = "ironloggui.explicitfiles";

	private static Properties mConfiguration;

	/**
	 * Death constructor for code convention -> final class because utility class
	 */
	private Configuration() {
	}

	public static void init() {

		LOGGER.info("Loading configuration file: " + FILENAME);
		mConfiguration = new Properties(IronLogGui.class.getResource(FILENAME).getPath());
		LOGGER.info("Loading configuration file done");

	}

	public static String getRootDir() throws PropertyException {
		return mConfiguration.getString(ROOTDIRFORSEARCH);
	}

	@SuppressWarnings("unchecked")
	public static List<String> getFilenamesForSearch() throws PropertyException {
		return (List<String>) mConfiguration.getValue(SEARCHFORFILES);
	}

	@SuppressWarnings("unchecked")
	public static List<String> getExplicitFileNames() throws PropertyException {
		return (List<String>) mConfiguration.getValue(EXPLICITFILES);
	}
}
