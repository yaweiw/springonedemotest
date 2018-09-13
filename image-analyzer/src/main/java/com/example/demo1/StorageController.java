package com.example.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

@RestController
@RequestMapping("/storage")
public class StorageController {

    @Value("blob://{containerName}/{blobName}")
    private Resource blobFile;

    @RequestMapping(method = RequestMethod.GET)
    public String readBlobFile() throws IOException {
        return StreamUtils.copyToString(
                this.blobFile.getInputStream(),
                Charset.defaultCharset()) + "\n";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String writeBlobFile(@RequestBody String data) throws IOException {
        try (OutputStream os = ((WritableResource) this.blobFile).getOutputStream()) {
            os.write(data.getBytes());
        }
        return "file was updated\n";
    }
}