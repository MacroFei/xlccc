package com.xlccc.ssm.controller.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlccc.ssm.common.Result;
import com.xlccc.ssm.pojo.Crop;
import com.xlccc.ssm.service.CropService;
import com.xlccc.ssm.util.Page;
import com.xlccc.ssm.util.ResponseUtil;
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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
@RequestMapping("")
public class CropController {
    @Autowired
    CropService cropService;

    @RequestMapping("crop_list") //crop展示
    public String List(Model model, Page page, HttpSession session) {
        String category = (String) session.getAttribute("category");
        PageHelper.offsetPage(page.getStart(), page.getCount());
        int totalNumber = 0;
        List<Crop> cs = cropService.list(category);
        int total = (int) new PageInfo<>(cs).getTotal();
        page.setTotal(total);
        totalNumber = cropService.selectTotalNumber_1(category);
        model.addAttribute("totalNumber", totalNumber);
        model.addAttribute("cs", cs);
        model.addAttribute("page", page);
        return "crop_management";
    }

    @RequestMapping("crop_add") //crop添加
    public String add(Crop crop, HttpSession session) {
        cropService.add(crop);
        return "redirect:/crop_list";
    }

    @RequestMapping("crop_delete") //crop删除
    public String delete(int id, HttpSession session) {
        cropService.delete(id);
        return "redirect:/crop_list";
    }

    @RequestMapping("crop_edit") //crop修改（跳转到修改页面）
    public String edit(int id, Model model) {
        Crop crop = cropService.get(id);
        model.addAttribute("crop", crop);
        return "crop_edit";
    }

    @RequestMapping("crop_update") //crop 数据更新
    public String update(Crop crop) {
        cropService.update(crop);
        return "redirect:/crop_list";
    }

    @RequestMapping("crop_deleteAll") //crop 删除全部
    public String deleteAll(String ids) {
        for (String idDemo : ids.split(",")
                ) {
            int id = Integer.parseInt(idDemo);
            cropService.delete(id);
            System.out.print("ashjiodjaios+删除成功");
        }
        return "redirect:/crop_list";
    }

    /**
     * 查询省份
     *
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "selectSheng", method = RequestMethod.POST)
    @ResponseBody
    public Result selectSheng(HttpServletResponse response, HttpSession session) throws Exception {
        String category = (String) session.getAttribute("category");
        List<Crop> list = cropService.selectSheng(category);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(list);
        result.put("rows", jsonArray);
        ResponseUtil.write(response, jsonArray);
        return null;
    }

    /**
     * 查询市
     *
     * @param crop
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "selectShi", method = RequestMethod.POST)
    @ResponseBody
    public Result selectShi(Crop crop, HttpServletResponse response, HttpSession session) throws Exception {
        String category = (String) session.getAttribute("category");
        List<Crop> list = cropService.selectShi(crop.getProvince(), category);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(list);
        result.put("rows", jsonArray);
        ResponseUtil.write(response, jsonArray);
        return null;
    }

    /**
     * 查询区/镇
     *
     * @param crop
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "selectQu", method = RequestMethod.POST)
    @ResponseBody
    public Result selectQu(Crop crop, HttpServletResponse response, HttpSession session) throws Exception {
        String category = (String) session.getAttribute("category");
        List<Crop> list = cropService.selectQu(crop.getProvince(), crop.getCity(), category);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(list);
        result.put("rows", jsonArray);
        ResponseUtil.write(response, jsonArray);
        return null;
    }

    /**
     * 查询品种名称
     *
     * @param crop
     * @param response
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "selectName", method = RequestMethod.POST)
    @ResponseBody
    public Result selectName(Crop crop, HttpServletResponse response, HttpSession session) throws Exception {
        String category = (String) session.getAttribute("category");
        List<Crop> list = cropService.selectName(crop.getProvince(), crop.getCity(), crop.getDistrict(), category);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(list);
        result.put("rows", jsonArray);
        ResponseUtil.write(response, jsonArray);
        return null;
    }

    @RequestMapping("crop_selectSSQN")
    public String selectSSQN(String values, Page page, Model model, HttpSession session) throws Exception {
        String category = (String) session.getAttribute("category");
        Crop c = new Crop();
        List<String> valueList = new ArrayList<String>();
        for (String value : values.split(",")
                ) {
            valueList.add(value);
        }
        c.setProvince(valueList.get(0));
        c.setCity(valueList.get(1));
        c.setDistrict(valueList.get(2));
        c.setVariety(valueList.get(3));
        //还有一个字段没有


        List<Crop> cs = cropService.selectSSQN(c.getProvince(), c.getCity(), c.getDistrict(), c.getVariety(), category);
        System.out.println(cs);
        PageHelper.offsetPage(page.getStart(), page.getCount());
        int total = (int) new PageInfo<>(cs).getTotal();
        page.setTotal(total);
        int totalNumber = cropService.selectTotalNumber_2(c.getProvince(), c.getCity(), c.getDistrict(), c.getVariety(), category);
        model.addAttribute("totalNumber", totalNumber);
        model.addAttribute("cs", cs);
        model.addAttribute("page", page);
        return "crop_management";
    }
}
