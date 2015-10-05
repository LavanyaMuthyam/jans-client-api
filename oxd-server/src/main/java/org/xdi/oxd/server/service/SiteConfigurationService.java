package org.xdi.oxd.server.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import com.google.inject.Inject;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xdi.oxd.common.CoreUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Yuriy Zabrovarnyy
 * @version 0.9, 28/09/2015
 */

public class SiteConfigurationService {

    /**
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(SiteConfigurationService.class);

    private static final String DEFAULT_SITE_CONFIG_JSON = "oxd-default-site-config.json";

    private static final int FILE_NAME_LENGTH = (UUID.randomUUID().toString() + ".json").length();

    private final Map<String, SiteConfiguration> sites = Maps.newConcurrentMap();
    private final Map<String, File> siteFiles = Maps.newConcurrentMap();

    @Inject
    ConfigurationService configurationService;

    public void load() {

        // load all files
        final List<File> files = Lists.newArrayList(Files.fileTreeTraverser().children(configurationService.getConfDirectoryFile()));
        for (File file : files) {
            if (!file.getName().equalsIgnoreCase(DEFAULT_SITE_CONFIG_JSON) &&
                    (file.getName().length() != FILE_NAME_LENGTH ||
                            !file.getName().endsWith(".json"))) { // precondition

                continue;
            }
            loadFile(file);
        }
    }

    private void loadFile(File file) {
        LOG.trace("Loading site file name: {}", file.getName());
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            sites.put(file.getName(), createConfiguration(fis));
            siteFiles.put(file.getName(), file);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        } finally {
            IOUtils.closeQuietly(fis);
        }
    }

    public SiteConfiguration defaultSiteConfiguration() {
        return sites.get(DEFAULT_SITE_CONFIG_JSON);
    }

    public SiteConfiguration getSite(String id) {
        return sites.get(id + ".json");
    }

    public Map<String, SiteConfiguration> getSites() {
        return Maps.newHashMap(sites);
    }

    public static SiteConfiguration createConfiguration(InputStream p_stream) {
        try {
            try {
                return CoreUtils.createJsonMapper().readValue(p_stream, SiteConfiguration.class);
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
            return null;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return null;
        }
    }

    public void persist(SiteConfiguration siteConfiguration) throws IOException {
        String fileName = siteConfiguration.getOxdId() + ".json";

        File file = siteFiles.get(fileName);
        if (file == null) {
            file = createSiteFile(fileName);
        }
        CoreUtils.createJsonMapper().writeValue(file, siteConfiguration);

        sites.put(file.getName(), siteConfiguration);
        siteFiles.put(file.getName(), file);
    }

    private File createSiteFile(String fileName) throws IOException {
        String filePath = configurationService.getConfDirectoryPath();
        if (!filePath.endsWith(File.separator)) {
            filePath = filePath + File.separator;
        }
        filePath = filePath + fileName;

        final File newFile = new File(filePath);
        if (newFile.createNewFile()) {
            siteFiles.put(fileName, newFile);
        }
        return newFile;
    }
}