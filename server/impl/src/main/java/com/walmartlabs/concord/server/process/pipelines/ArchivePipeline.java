package com.walmartlabs.concord.server.process.pipelines;

import com.google.inject.Injector;
import com.walmartlabs.concord.server.ansible.InventoryProcessor;
import com.walmartlabs.concord.server.ansible.PrivateKeyProcessor;
import com.walmartlabs.concord.server.process.pipelines.processors.*;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Processing self-contained archives.
 * <p>
 * Runs a process using an archive, provided by a user.
 */
@Named
public class ArchivePipeline extends Pipeline {

    private final ExceptionProcessor exceptionProcessor;

    @Inject
    public ArchivePipeline(Injector injector) {
        super(injector,
                PreparingProcessor.class,
                WorkspaceArchiveProcessor.class,
                WorkspaceRequestDataParsingProcessor.class,
                RequestDataParsingProcessor.class,
                ActiveProfilesProcessor.class,
                ProjectDefinitionProcessor.class,
                ProjectConfigurationProcessor.class,
                RequestDefaultsParsingProcessor.class,
                InventoryProcessor.class,
                PrivateKeyProcessor.class,
                ExternalTemplateProcessor.class,
                DependenciesProcessor.class,
                UserInfoProcessor.class,
                RequestDataStoringProcessor.class,
                ValidatingProcessor.class,
                StateImportingProcessor.class,
                EnqueueingProcessor.class);

        this.exceptionProcessor = injector.getInstance(FailProcessor.class);
    }

    @Override
    protected ExceptionProcessor getExceptionProcessor() {
        return exceptionProcessor;
    }
}
