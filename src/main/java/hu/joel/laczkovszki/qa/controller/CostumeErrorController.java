package hu.joel.laczkovszki.qa.controller;

import hu.joel.laczkovszki.qa.exception.ApiExceptionHandler;
import hu.joel.laczkovszki.qa.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CostumeErrorController implements ErrorController {
    private final ApiExceptionHandler apiExceptionHandler;

    @Autowired
    public CostumeErrorController(ApiExceptionHandler apiExceptionHandler) {
        this.apiExceptionHandler = apiExceptionHandler;
    }

    @GetMapping("/error")
    @ResponseBody
    public ResponseEntity<Object> getApiRequestException() {
        return apiExceptionHandler.handleApiRequestException(new ApiRequestException("Something is wrong"));
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
