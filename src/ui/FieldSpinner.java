package ui;

import javax.swing.JSpinner;
import javax.swing.SpinnerModel;

public class FieldSpinner extends JSpinner
{
    protected Object referredObject = null;
    protected String fieldName = "";
    
    public FieldSpinner(SpinnerModel model, Object referredObject, String fieldName)
    {
        super(model);
        this.referredObject = referredObject;
        this.fieldName = fieldName;
    }

    public Object getReferredObject()
    {
        return referredObject;
    }

    public String getFieldName()
    {
        return fieldName;
    }
    
}
