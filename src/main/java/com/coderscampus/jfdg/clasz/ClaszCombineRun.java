package com.coderscampus.jfdg.clasz;

import java.io.StringWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.coderscampus.generator.Cnst;
import com.coderscampus.generator.domain.GenMeta;
import com.coderscampus.generator.util.InternalWriteFolder;
import com.coderscampus.generator.util.Names;
import com.coderscampus.jfdg.project.ProjectGen;

public class ClaszCombineRun {
	public void go() {
		GenMeta introGenMeta = new GenMeta("class_intro");
		GenMeta projectGenMeta = new GenMeta("project");
		GenMeta classGenMeta = new GenMeta("class");
		GenMeta completeGenMeta = new GenMeta("classComplete", "CLASS.md", "../rebarium/", InternalWriteFolder.DEFAULT, Paths.get("class"));
		List<GenMeta> genMetaList = new ArrayList<GenMeta>();
		genMetaList.add(introGenMeta);
		genMetaList.add(projectGenMeta);
		genMetaList.add(classGenMeta);
		genMetaList.add(completeGenMeta);
		ClaszIntroGen claszIntroGen = new ClaszIntroGen(genMetaList, 0);
		ProjectGen projectGen = new ProjectGen(genMetaList, 1);
		ClaszGen claszGen = new ClaszGen(genMetaList, 2);
		ClaszCompleteGen claszCompleteGen = new ClaszCompleteGen(genMetaList, 3);
		// setup complete, now the processing
		StringWriter stringWriter = new ClaszIntroGen(genMetaList, 0).generate(null);
		for (int i = 0; i < 25; i++) {
			String name = Names.randomName().toString();
			String claszName = Names.upLow(name);
			String secondName = Names.randomName().toString();
			String secondClassName = Names.upLow(secondName);
			projectGenMeta = new GenMeta("project", name, Cnst.PKG_SERVICE, claszName, null, null);
			classGenMeta = new GenMeta("class", name, "util", secondClassName, null, null);
			genMetaList.set(1, projectGenMeta);
			genMetaList.set(2, classGenMeta);
			projectGen = new ProjectGen(genMetaList, 1);
			claszGen = new ClaszGen(genMetaList, 2);
			stringWriter = projectGen.generate(stringWriter);
			stringWriter = claszGen.generate(stringWriter);

		}
		claszCompleteGen.generate(stringWriter);
	}
}
