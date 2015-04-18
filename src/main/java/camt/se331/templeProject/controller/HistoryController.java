package camt.se331.templeProject.controller;

import camt.se331.templeProject.entity.History;
import camt.se331.templeProject.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dell on 14/4/2558.
 */
@RestController
@RequestMapping("/")
public class HistoryController {

        @Autowired
        HistoryService historyService;

        @RequestMapping(value = "History",method = RequestMethod.GET)
        public List<History> getHistory(){
            return historyService.getHistory();
        }

        @RequestMapping(value = "History",method = RequestMethod.PUT)
        public  History updateHistory(@RequestBody History history, BindingResult bindingResult){
            return historyService.updateHistory(history);
        }

    @RequestMapping(value = "History",method = RequestMethod.POST)
    public @ResponseBody History add(@RequestBody History history, BindingResult bindingResult){
        return historyService.addHistory(history);
    }




}
