package com.example.wbdvsp20xiaohaiserverjava.services;

import com.example.wbdvsp20xiaohaiserverjava.models.Widget;
import com.example.wbdvsp20xiaohaiserverjava.repositories.TopicRepository;
import com.example.wbdvsp20xiaohaiserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WidgetService {

    @Autowired
    WidgetRepository widgetRepository;

    @Autowired
    TopicRepository topicRepository;

    public int deleteWidget(Integer widgetId) {
        widgetRepository.deleteById(widgetId);
        return 1;
    }

    public Widget createWidget(Widget newWidget) {
        return widgetRepository.save(newWidget);
    }

    public int updateWidget(int widgetId, Widget updatedWidget) {
        Widget oldWidget = widgetRepository.findWidgetById(widgetId);
        oldWidget.setTitle(updatedWidget.getTitle());
        oldWidget.setSize(updatedWidget.getSize());
        oldWidget.setIsInOrder(updatedWidget.getIsInOrder());

        widgetRepository.save(oldWidget);
        return 1;
    }

    public List<Widget> findAllWidgets() {
        return widgetRepository.findAllWidgets();
    }

    public List<Widget> findWidgetsForTopic(int topicId) {
        return widgetRepository.findWidgetsForTopic(topicId);
    }

    public Widget findWidgetById(int wid) {
        return widgetRepository.findWidgetById(wid);
    }
}
