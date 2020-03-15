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

    public int updateWidget(Integer widgetId, Widget updatedWidget) {
        Widget oldWidget = widgetRepository.findWidgetById(widgetId);

        oldWidget.setTitle(updatedWidget.getTitle());
        oldWidget.setSize(updatedWidget.getSize());
        oldWidget.setIsInOrder(updatedWidget.getIsInOrder());
        oldWidget.setType(updatedWidget.getType());
        oldWidget.setText(updatedWidget.getText());
        oldWidget.setSrc(updatedWidget.getSrc());
        oldWidget.setUrl(updatedWidget.getUrl());
        oldWidget.setHref(updatedWidget.getHref());

        oldWidget.setWidth(updatedWidget.getWidth());
        oldWidget.setHeight(updatedWidget.getHeight());
        oldWidget.setCssClass(updatedWidget.getCssClass());
        oldWidget.setStyle(updatedWidget.getStyle());
        oldWidget.setValue(updatedWidget.getValue());

        widgetRepository.save(oldWidget);
        return 1;
    }

    public List<Widget> findAllWidgets() {
        return widgetRepository.findAllWidgets();
    }

    public List<Widget> findWidgetsForTopic(Integer topicId) {
        return widgetRepository.findWidgetsForTopic(topicId);
    }

    public Widget findWidgetById(Integer wid) {
        return widgetRepository.findWidgetById(wid);
    }
}
