package com.example.wbdvsp20xiaohaiserverjava.controllers;

import com.example.wbdvsp20xiaohaiserverjava.models.Topic;
import com.example.wbdvsp20xiaohaiserverjava.models.Widget;
import com.example.wbdvsp20xiaohaiserverjava.services.TopicService;
import com.example.wbdvsp20xiaohaiserverjava.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

    @Autowired
    WidgetService widgetService;

    @Autowired
    TopicService topicService;

    @PostMapping("/api/topics/{topicId}/widgets")
    public Widget createWidget(
            @PathVariable("topicId") Integer topicId,
            @RequestBody Widget newWidget) {
        return topicService.createWidgetForTopic(topicId, newWidget);
    }

    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(@PathVariable("tid") Integer tid) {
        return widgetService.findWidgetsForTopic(tid);
    }

    @PutMapping("/api/widgets/{wid}")
    public int updateWidget(@PathVariable("wid") Integer widgetId,
                            @RequestBody Widget widget) {
        return widgetService.updateWidget(widgetId, widget);
    }

    @DeleteMapping("/api/widgets/{wid}")
    public int deleteWidget(@PathVariable("wid") Integer widgetId) {
        return widgetService.deleteWidget(widgetId);
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return widgetService.findAllWidgets();
    }

    @GetMapping("/api/widgets/{widgetId}")
    public Widget findWidgetById(@PathVariable("widgetId") Integer wid) {
        return widgetService.findWidgetById(wid);
    }
}
