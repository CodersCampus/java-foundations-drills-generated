package com.coderscampus.jfdg.project;

import java.io.StringWriter;

import com.coderscampus.generator.domain.GenMeta;
import com.coderscampus.generator.trial.GenBase;
import com.coderscampus.generator.util.Names;
import com.coderscampus.generator.util.Rndm;
import com.coderscampus.generator.util.StringUtils_;

public class ProjectGen extends GenBase {

    public ProjectGen(GenMeta genMeta) {
        super(genMeta);
    }

    @Override
    public StringWriter generate(StringWriter stringWriter) {
        String appSuffix = StringUtils_.upLow(Rndm.nameMainClass());
        this.context.put("otherName", Names.randomName().toLowerCase());
        this.context.put("AppSuffix", appSuffix);
        this.context.put("ClassName", this.genMeta.getName());
        this.context.put("name", this.genMeta.getName().toLowerCase());
        this.context.put("package", this.genMeta.getPakage());
        merge(stringWriter);
        return writer;
    }

    public void write(){
        // ao nothing
    }

}
