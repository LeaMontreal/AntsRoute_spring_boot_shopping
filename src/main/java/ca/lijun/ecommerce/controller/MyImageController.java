package ca.lijun.ecommerce.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class MyImageController {
  @RequestMapping(value = "/assets/images/products/{category}/{filename}", method = RequestMethod.GET,
          produces = MediaType.IMAGE_JPEG_VALUE)
  public void getImage(
          @PathVariable("category") String category,
          @PathVariable("filename") String filename, HttpServletResponse response) throws IOException {

    var imgFile = new ClassPathResource("/assets/images/products/" + category + "/" + filename);

    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
    StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
  }
}
