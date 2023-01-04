package com.coderscampus.jfdg.clasz;

import java.io.StringWriter;
import java.util.List;

import com.coderscampus.generator.domain.GenMeta;
import com.coderscampus.generator.service.GenBase;
import com.coderscampus.generator.util.Names;

public class ClaszGen extends GenBase {

    public ClaszGen(List<GenMeta> genMetaList, int defaultPosition) {
        super(genMetaList, defaultPosition);
    }

    @Override
    public StringWriter generate(StringWriter stringWriter) {
        String secondMethod = Names.randomName();
        String argument = Names.randomName();
        String someValue = Names.randomName();
        this.context.put("argument", argument);
        this.context.put("secondMethod", secondMethod);
        this.context.put("SecondClass", this.genMetaList.get(defaultPosition).getName());
        this.context.put("package", this.genMetaList.get(defaultPosition).getPakage());
        this.context.put("someValue", someValue);
        merge(stringWriter);
        return writer;
    }

    public void write(){
        // ao nothing
    }

}
