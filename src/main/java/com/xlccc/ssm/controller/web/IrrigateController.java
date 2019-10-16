package com.xlccc.ssm.controller.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlccc.ssm.common.Result;
import com.xlccc.ssm.pojo.Irrigate;
import com.xlccc.ssm.service.IrrigateService;
import com.xlccc.ssm.util.Page;
import com.xlccc.ssm.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class IrrigateController {

    @Autowired
    IrrigateService irrigateService;

    @RequestMapping("irrigate_list")  //irrigate展示
    public String list(Model model, Page page, HttpSession session) {
        String category = (String) session.getAttribute("category");
        PageHelper.offsetPage(page.getStart(), page.getCount());
        int totalNumber = 0;
        List<Irrigate> is = irrigateService.list(category);
        int total = (int) new PageInfo<>(is).getTotal();
        page.setTotal(total);
        totalNumber = irrigateService.selectTotalNumber_1(category);
        model.addAttribute("totalNumber", totalNumber);
        model.addAttribute("is", is);
        model.addAttribute("page", page);
        return "irrigation_management";
    }

    @RequestMapping("irrigate_add") //irrigate添加
    public String add(Irrigate irrigate, HttpSession session) {
        irrigateService.add(irrigate);
        return "irrigate_list";
    }

    @RequestMapping("irrigate_delete") //irrigate删除
    public String delete(int id, Model model) {
        irrigateService.delete(id);
        return "redirect:/irrigate_list";
    }

    @RequestMapping("irrigate_edit") //irrigate修改（跳转到修改页面）
    public String edit(int id, Model model) {
        Irrigate i = irrigateService.get(id);
        model.addAttribute("i", i);
        return "irrigation_edit";
    }

    @RequestMapping("irrigate_update") //irrigate数据更新
    public String update(Irrigate i) {

            irrigateService.update(i);
        return "redirect:/irrigate_list";

    }

    @RequestMapping("irrigate_deleteAll") //irrigate删除全部
    public String deleteAll(String ids) {
        for (String idDemo : ids.split(",")
                ) {
            int id = Integer.parseInt(idDemo);
            irrigateService.delete(id);

        }
        return "redirect:/irrigate_list";
    }

    /**
     * 查询省份
     *
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "irrigate_selectSheng", method = RequestMethod.POST)
    @ResponseBody
    public Result selectSheng(HttpServletResponse response, HttpSession session) throws Exception {
        String category = (String) session.getAttribute("category");
        List<Irrigate> list = irrigateService.selectSheng(category);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(list);
        result.put("rows", jsonArray);
        ResponseUtil.write(response, jsonArray);
        return null;
    }

    /**
     * 查询市
     *
     * @param irrigate
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "irrigate_selectShi", method = RequestMethod.POST)
    @ResponseBody
    public Result selectShi(Irrigate irrigate, HttpServletResponse response, HttpSession session) throws Exception {
        String category = (String) session.getAttribute("category");
        List<Irrigate> list = irrigateService.selectShi(irrigate.getProvince(), category);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(list);
        result.put("rows", jsonArray);
        ResponseUtil.write(response, jsonArray);
        return null;
    }

    /**
     * 查询区/镇
     *
     * @param irrigate
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "irrigate_selectQu", method = RequestMethod.POST)
    @ResponseBody
    public Result selectQu(Irrigate irrigate, HttpServletResponse response, HttpSession session) throws Exception {
        String category = (String) session.getAttribute("category");
        List<Irrigate> list = irrigateService.selectQu(irrigate.getProvince(), irrigate.getCity(), category);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(list);
        result.put("rows", jsonArray);
        ResponseUtil.write(response, jsonArray);
        return null;
    }

    /**
     * 查询品种名称
     *
     * @param irrigate
     * @param response
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "irrigate_selectName", method = RequestMethod.POST)
    @ResponseBody
    public Result selectName(Irrigate irrigate, HttpServletResponse response, HttpSession session) throws Exception {
        String category = (String) session.getAttribute("category");
        List<Irrigate> list = irrigateService.selectName(irrigate.getProvince(), irrigate.getCity(), irrigate.getDistrict(), category);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(list);
        result.put("rows", jsonArray);
        ResponseUtil.write(response, jsonArray);
        return null;
    }

    /**
     * 查询操作
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("irrigation_selectSSQN")
    public String selectSSQN(String values, Page page, Model model, HttpSession session) {
        String category = (String) session.getAttribute("category");
        Irrigate i = new Irrigate();
        List<String> valueList = new ArrayList<String>();
        for (String value : values.split(",")
                ) {
            valueList.add(value);
        }
        i.setProvince(valueList.get(0));
        i.setCity(valueList.get(1));
        i.setDistrict(valueList.get(2));
        i.setSerial_number(valueList.get(3));

        List<Irrigate> is = irrigateService.selectSSQN(i.getProvince(), i.getCity(), i.getDistrict(), i.getSerial_number(), category);
        PageHelper.offsetPage(page.getStart(), page.getCount());
        int total = (int) new PageInfo<>(is).getTotal();
        page.setTotal(total);
        int totalNumber = irrigateService.selectTotalNumber_2(i.getProvince(), i.getCity(), i.getDistrict(), i.getSerial_number(), category);
        model.addAttribute("totalNumber", totalNumber);
        model.addAttribute("is", is);
        model.addAttribute("page", page);
        return "irrigation_management";


    }

}
