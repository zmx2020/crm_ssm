package net.wanho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2019/4/15.
 */
@RequestMapping("/ControlServlet")
@Controller
public class ControlController {
    @RequestMapping("/countAll")
    protected String countAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*try {
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return "forward:/WEB-INF/index.jsp";

    }

}
