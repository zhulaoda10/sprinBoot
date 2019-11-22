package com.example.demo.kaptcha;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/kaptcha")
public class KaptchaController {
	 @Autowired(required=true)
	 private Producer captchaProducer;
	 
	@Autowired
	DefaultKaptcha defaultKaptcha;
	 
	 @RequestMapping("/getCode")
	    public ModelAndView getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        response.setDateHeader("Expires", 0);
	        // Set standard HTTP/1.1 no-cache headers.
	        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
	        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
	        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
	        // Set standard HTTP/1.0 no-cache header.
	        response.setHeader("Pragma", "no-cache");
	        response.setContentType("image/jpeg");
	        // create the text for the image
	        String capText = captchaProducer.createText();
	        log.info("******************验证码是: " + capText + "******************");
	        // store the text in the session
	        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
	        // create the image with the text
	        BufferedImage bi = captchaProducer.createImage(capText);
	        ServletOutputStream out = response.getOutputStream();
	        // write the data out
	        ImageIO.write(bi, "jpg", out);
	        try {
	            out.flush();
	        } finally {
	            out.close();
	        }
	        return null;
	    }
	 

	 
		@GetMapping("/baseCode")
		@ResponseBody
		public String generateKaptcha(HttpServletRequest request, HttpServletResponse response) {
			log.debug("coming into generateKaptcha method");
			String jpg_base64 = null;
			try {
				byte[] captchaChallengeAsJpeg = null;
				ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
				String createText = defaultKaptcha.createText();
				request.getSession().setAttribute("vrifyCode", createText);
				BufferedImage challenge = defaultKaptcha.createImage(createText);
				ImageIO.write(challenge, "jpg", jpegOutputStream);
				captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
				BASE64Encoder encoder = new BASE64Encoder();
				jpg_base64 = encoder.encodeBuffer(captchaChallengeAsJpeg).trim();
				jpg_base64 = jpg_base64.replaceAll("\n", "").replaceAll("\r", "");
			} catch (IOException e) {
//				log.error("generate captcha failed", e);
//				return CommonUtil.errorJsonStr(ErrorEnum.E_514);
			}
			return jpg_base64;
		}
	 
		@GetMapping("/vrifyKaptcha")
		public @ResponseBody String vrifyKaptcha(HttpServletRequest httpServletRequest,
				HttpServletResponse httpServletResponse) {
			log.debug("coming into generateKaptcha method");
			String captchaId = (String) httpServletRequest.getSession().getAttribute("vrifyCode");
			String parameter = httpServletRequest.getParameter("vrifyCode");
			if (!captchaId.equals(parameter)) {
				log.error("vrity captcha failed");
//				return CommonUtil.errorJsonStr(ErrorEnum.E_511);
			} else {
				log.debug("vrity captcha success");
//				return CommonUtil.successJsonStr();
			}
			return null;
		}
	 
}
