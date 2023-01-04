package com.coderscampus.jfdg.project;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.coderscampus.generator.domain.GenMeta;
import com.coderscampus.generator.service.GenBase;

public class ProjectCompleteGen extends GenBase {

    public ProjectCompleteGen(List<GenMeta> genMetaList, int defaultPosition) {
        super(genMetaList, defaultPosition);
    }

    @Override
    public StringWriter generate(StringWriter stringWriter) {
        this.context.put("name", new String("Velocity"));
        this.context.put("city", loremIpsum.getCity());
        this.context.put("ClassName", this.genMetaList.get(defaultPosition).getName());
        this.context.put("package", this.genMetaList.get(defaultPosition).getPakage());
        merge(stringWriter);
        write();
        return writer;
    }

    public void write(){
        System.out.println(genMetaList.get(defaultPosition).getWritePath());

        System.out.println(writer.toString());
        Path path = Paths.get(genMetaList.get(defaultPosition).getWritePath());
        try {
            Files.createDirectories(path.getParent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileWriter fileWriter = new FileWriter(genMetaList.get(defaultPosition).getWritePath())) {
            fileWriter.write(writer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
