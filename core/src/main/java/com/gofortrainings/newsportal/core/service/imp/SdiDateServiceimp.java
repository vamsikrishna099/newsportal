package com.gofortrainings.newsportal.core.service.imp;

import com.gofortrainings.newsportal.core.service.SdiDateService;
import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.adobe.cq.wcm.core.components.commons.editor.dialog.childreneditor.Item.LOG;

@Component(service = SdiDateService.class)
public class SdiDateImpl {
    Date date = new Date();
    String dateStr = dateToString(date, "yyyy-MM-dd");

    /**
     * Get string from date for the given format
     *
     * @param date
     * @param format
     * @return date string
     */

    public static String dateToString(Date date, String format) {
        if (date == null || StringUtils.isBlank(format)) {
            return StringUtils.EMPTY;
        }
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            return dateFormat.format(date.getTime());
        }
        catch (Exception e) {
            LOG.error("Not able to convert date to string : {}", e.getMessage());
        }
        return StringUtils.EMPTY;
    }

}
