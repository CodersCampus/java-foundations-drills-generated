package com.coderscampus.jfdg.clasz;

import com.coderscampus.generator.Cnst;
import com.coderscampus.generator.domain.GenMeta;
import com.coderscampus.generator.util.InternalWriteFolder;
import com.coderscampus.generator.util.Names;
import com.coderscampus.jfdg.project.ProjectCompleteGen;
import com.coderscampus.jfdg.project.ProjectGen;
import com.coderscampus.jfdg.project.ProjectIntroGen;

import java.io.StringWriter;
import java.nio.file.Paths;

public class ClaszCombineRun {
    public void  go(){
        GenMeta introGenMeta = new GenMeta("class_intro");
        StringWriter stringWriter = new ClaszIntroGen(introGenMeta).generate(null);
        for(int i=0;i<25;i++){
            String name = Names.randomName().toString();
            String claszName = Names.upLow(name);
            GenMeta projectGenMeta = new GenMeta("project", name, Cnst.PKG_SERVICE, claszName, null, null);
            ProjectGen projectGen = new ProjectGen(projectGenMeta);
            stringWriter = projectGen.generate(stringWriter);
            String secondName = Names.randomName().toString();
            String secondClassName = Names.upLow(secondName);
            GenMeta secondGenMeta = new GenMeta("class", name, "util", secondClassName, null, null);
            ClaszGen classGen = new ClaszGen(secondGenMeta);
            stringWriter = classGen.generate(stringWriter);


        }

        ProjectCompleteGen projectCompleteGen = new ProjectCompleteGen(new GenMeta("projectComplete", "CLASS.md", "../rebarium/", InternalWriteFolder.DEFAULT, Paths.get("project")));
        projectCompleteGen.generate(stringWriter);
    }
}
