package com.trial.config;

import java.io.IOException;
import java.io.InputStream;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class droolsConfig {
	private KieServices kieServices = KieServices.Factory.get();
	
	private KieFileSystem getKieFileSystem() throws IOException{
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		InputStream is = ResourceFactory.newClassPathResource("rules/ProgressSheet.drl.xlsx").getInputStream();
        SpreadsheetCompiler compiler = new SpreadsheetCompiler();
        String drl = compiler.compile(is, InputType.XLS);
//        kieFileSystem.write(ResourceFactory.newClassPathResource("rules/Progress.drl"));
		kieFileSystem.write(ResourceFactory.newClassPathResource("rules/ProgressSheet.drl.xlsx"));
		System.out.println(drl);
		return kieFileSystem;
//		kieFileSystem.write(ResourceFactory.newClassPathResource("rules/Progress.drl"));
//		return kieFileSystem;
	}

    @Bean
    KieContainer getKieContainer() throws IOException{
		System.out.println("Container Created...");
		getKieRepository();
		KieBuilder kb = kieServices.newKieBuilder(getKieFileSystem());
		kb.buildAll();
		KieModule kieModule = kb.getKieModule();
		KieContainer kContainer = kieServices.newKieContainer(kieModule.getReleaseId());
		return kContainer;
	}
	
	private void getKieRepository() throws IOException {
		final KieRepository kieRepository = kieServices.getRepository();
		kieRepository.addKieModule(new KieModule() {
			public ReleaseId getReleaseId() {
				return kieRepository.getDefaultReleaseId();
			}
		});
	}

    @Bean
    KieSession getKieSession() throws IOException{
		System.out.println("Session created... ");
		return getKieContainer().newKieSession();
	}
}

