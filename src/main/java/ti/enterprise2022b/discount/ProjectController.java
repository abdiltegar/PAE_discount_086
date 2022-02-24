/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ti.enterprise2022b.discount;

import ch.qos.logback.core.pattern.Converter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Tegar
 */
@Controller
public class ProjectController {
    
    @RequestMapping("")
    public String index(Model model){
        return "index";
    }
    
    @RequestMapping(value = "/discount", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Discount discount(Model model,HttpServletRequest data){
        
        Discount respon = new Discount();
        if(data.getParameter("diskon") != null && data.getParameter("hargaAsli") != null){
            int diskon = Integer.parseInt(data.getParameter("diskon"));
            Double hargaAsli = Double.parseDouble(data.getParameter("hargaAsli"));

            Double besarDiskon = (Double.valueOf(diskon) / Double.valueOf(100)) * hargaAsli;
            Double hargaDiskon = hargaAsli - besarDiskon;

            respon = new Discount();
            respon.diskon = diskon;
            respon.hargaAsli = hargaAsli;
            respon.besarDiskon = besarDiskon;
            respon.hargaDiskon = hargaDiskon;
        }
        
        return respon;
    }
}
