package at.rodrigo.api.gateway.controller;

import at.rodrigo.api.gateway.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import org.json.JSONObject;

@RestController
@Slf4j
public class ErrorController {

    @RequestMapping( path="/error", method= RequestMethod.GET)
    public ResponseEntity<String> get(HttpServletRequest request) {
        return buildResponse(request);
    }

    @RequestMapping( path="/error", method=RequestMethod.POST)
    public ResponseEntity<String> post(HttpServletRequest request) {
        return buildResponse(request);
    }

    @RequestMapping( path="/error", method=RequestMethod.PUT)
    public ResponseEntity<String> put(HttpServletRequest request) {
        return buildResponse(request);
    }

    @RequestMapping( path="/error", method=RequestMethod.DELETE)
    public ResponseEntity<String> delete(HttpServletRequest request) {
        return buildResponse(request);
    }

    private ResponseEntity<String> buildResponse(HttpServletRequest request) {
        JSONObject result = new JSONObject();

        if(request.getHeader(Constants.REASON_HEADER) != null && request.getHeader(Constants.REASON_HEADER).equals("503")) {
            result.put("error", "API not available");
            return new ResponseEntity<>(result.toString(), HttpStatus.SERVICE_UNAVAILABLE);
        }

        result.put("error", "Bad request");
        log.info(request.getHeader("routeId"));
        return new ResponseEntity<>(result.toString(), HttpStatus.BAD_REQUEST);
    }


}
