package Network.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by son on 2018-11-20.
 */
@AllArgsConstructor
@Data
public class AjaxModel {
    private Boolean success;
    private String message;
    private Object data;
    private String exception;
}
