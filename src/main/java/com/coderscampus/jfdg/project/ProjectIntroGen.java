package com.coderscampus.jfdg.project;

import java.io.StringWriter;
import java.util.List;

import com.coderscampus.generator.domain.GenMeta;
import com.coderscampus.generator.service.GenBase;

public class ProjectIntroGen extends GenBase {

    public ProjectIntroGen(List<GenMeta> genMetaList, int defaultPosition) {
        super(genMetaList, defaultPosition);
    }

    @Override
    public StringWriter generate(StringWriter stringWriter) {
        this.context.put("name", new String("Velocity"));
        this.context.put("city", loremIpsum.getCity());
        this.context.put("ClassName", this.genMetaList.get(defaultPosition).getName());
        this.context.put("package", this.genMetaList.get(defaultPosition).getPakage());
        merge(null);
        write();
        return writer;
    }

    public void write(){
        // do nothing
    }

}
