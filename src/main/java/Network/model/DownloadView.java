package Network.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by son on 2018-11-26.
 */
@Slf4j
@Configuration
public class DownloadView extends AbstractView {
    @Value("#{serverXmlFile['download.filename']}") private String fileName;

    public DownloadView() {
        setContentType("application/download; charset=utf-8");
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String text = (String)map.get("text");
        if(request.getHeader("User-Agent").contains("MSIE")) {
            fileName = URLEncoder.encode(fileName, "utf-8");
        } else {
            fileName = new String(fileName.getBytes("utf-8"));
        }
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\";", fileName));
        response.setHeader("Content-Transfer-Encoding", "binary");

        response.getOutputStream().write(text.getBytes());
    }
}
