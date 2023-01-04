package com.coderscampus.jfdg.project;

import java.io.StringWriter;
import java.util.List;

import com.coderscampus.generator.domain.GenMeta;
import com.coderscampus.generator.service.GenBase;
import com.coderscampus.generator.util.Names;
import com.coderscampus.generator.util.Rndm;
import com.coderscampus.generator.util.StringUtils_;

public class ProjectGen extends GenBase {

    public ProjectGen(List<GenMeta> genMetaList, int defaultPosition) {
        super(genMetaList, defaultPosition);
    }

    @Override
    public StringWriter generate(StringWriter stringWriter) {
        String appSuffix = StringUtils_.upLow(Rndm.nameMainClass());
        this.context.put("otherName", Names.randomName().toLowerCase());
        this.context.put("AppSuffix", appSuffix);
        this.context.put("ClassName", this.genMetaList.get(defaultPosition).getName());
        this.context.put("name", this.genMetaList.get(defaultPosition).getName().toLowerCase());
        this.context.put("package", this.genMetaList.get(defaultPosition).getPakage());
        merge(stringWriter);
        return writer;
    }

    public void write(){
        // ao nothing
    }

}
