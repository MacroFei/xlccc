package com.xlccc.ssm.controller.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlccc.ssm.common.Result;
import com.xlccc.ssm.pojo.Equipment;
import com.xlccc.ssm.pojo.EquipmentExample;
import com.xlccc.ssm.service.EquipmentService;
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
public class EquipmentController {
    @Autowired
    EquipmentService equipmentService;

    @RequestMapping("equipment_list")//设备展示
    public String list(Model model, Page page, HttpSession session) {
        String category = (String) session.getAttribute("category");
        PageHelper.offsetPage(page.getStart(), page.getCount()); //分页
        int totalNumber = 0;
        List<Equipment> es = equipmentService.list(category);
        int total = (int) new PageInfo<>(es).getTotal();
        page.setTotal(total);
        totalNumber = equipmentService.selectTotalNumber_1(category);
        model.addAttribute("totalNumber", totalNumber);
        model.addAttribute("es", es);
        model.addAttribute("page", page);
        return "equipment_management";
    }

    @RequestMapping("equipment_add")  //设备添加
    public String add(Equipment equipment, HttpSession httpSession) {
        equipmentService.add(equipment);
        return "redirect:/equipment_list";
    }

    @RequestMapping("equipment_delete")//设备删除
    public String delete(int id, HttpSession session) {
        equipmentService.delete(id);
        return "redirect:/equipment_list";

    }

    @RequestMapping("equipment_edit") //设备修改（跳转到修改页面）
    public String edit(int id, Model model) {
        Equipment e = equipmentService.get(id);
        model.addAttribute("e", e);
        return "equipment_edit"; //  需要修改为编辑页面
    }

    @RequestMapping("equipment_update") //设备更新
    public String update(Equipment equipment) {
        equipmentService.update(equipment);
        return "redirect:/equipment_list";
    }

    @RequestMapping("equipment_deleteAll") //删除全部
    public String deleteAll(String ids) {
        for (String idDemo : ids.split(",")
                ) {
            int id = Integer.parseInt(idDemo);
            equipmentService.delete(id);

        }
        return "redirect:/equipment_list";
    }

    /**
     * 查询省份
     *
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "equipment_selectSheng", method = RequestMethod.POST)
    @ResponseBody
    public Result selectSheng(HttpServletResponse response, HttpSession session) throws Exception {
        String category = (String) session.getAttribute("category");
        List<Equipment> list = equipmentService.selectSheng(category);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(list);
        result.put("rows", jsonArray);
        ResponseUtil.write(response, jsonArray);
        return null;
    }

    /**
     * 查询市
     *
     * @param equipment
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "equipment_selectShi", method = RequestMethod.POST)
    @ResponseBody
    public Result selectShi(Equipment equipment, HttpServletResponse response, HttpSession session) throws Exception {
        String category = (String) session.getAttribute("category");
        List<Equipment> list = equipmentService.selectShi(equipment.getProvince(), category);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(list);
        result.put("rows", jsonArray);
        ResponseUtil.write(response, jsonArray);
        return null;
    }

    /**
     * 查询区/镇
     *
     * @param equipment
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "equipment_selectQu", method = RequestMethod.POST)
    @ResponseBody
    public Result selectQu(Equipment equipment, HttpServletResponse response, HttpSession session) throws Exception {
        String category = (String) session.getAttribute("category");
        List<Equipment> list = equipmentService.selectQu(equipment.getProvince(), equipment.getCity(), category);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(list);
        result.put("rows", jsonArray);
        ResponseUtil.write(response, jsonArray);
        return null;
    }

    /**
     * 查询品种名称
     *
     * @param equipment
     * @param response
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "equipment_selectName", method = RequestMethod.POST)
    @ResponseBody
    public Result selectName(Equipment equipment, HttpServletResponse response, HttpSession session) throws Exception {
        String category = (String) session.getAttribute("category");
        List<Equipment> list = equipmentService.selectName(equipment.getProvince(), equipment.getCity(), equipment.getDistrict(), category);
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
    @RequestMapping("equipment_selectSSQN")
    public String selectSSQN(String values, Page page, Model model, HttpSession session) throws Exception {
        String category = (String) session.getAttribute("category");
        Equipment e = new Equipment();
        List<String> valueList = new ArrayList<String>();

        for (String value : values.split(",")) {
            valueList.add(value);
        }

        e.setProvince(valueList.get(0));
        e.setCity(valueList.get(1));
        e.setDistrict(valueList.get(2));
        e.setSerial_number(valueList.get(3));

        List<Equipment> es = equipmentService.selectSSQN(e.getProvince(), e.getCity(), e.getDistrict(), e.getSerial_number(), category);
        PageHelper.offsetPage(page.getStart(), page.getCount());
        int total = (int) new PageInfo<>(es).getTotal();
        page.setTotal(total);
        int totalNumber = equipmentService.selectTotalNumber_2(e.getProvince(), e.getCity(), e.getDistrict(), e.getSerial_number(), category);
        model.addAttribute("totalNumber", totalNumber);
        model.addAttribute("es", es);
        model.addAttribute("page", page);
        return "equipment_management";

    }
}
