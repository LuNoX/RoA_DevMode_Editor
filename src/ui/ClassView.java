package ui;

import javax.swing.JComponent;

public class ClassView
{
    protected JComponent childComponent = null;
    protected ClassView childClassView = null;
    
    public ClassView()
    {
        this.initializeEverything();
    }
    
    public void initializeEverything()
    {
        this.initializeChildClassView();
        this.initializeChildComponent();
    }
    
    public void initializeChildClassView()
    {
        
    }
    
    public void initializeChildComponent()
    {
        if(this.childClassView != null)
        {
            this.childClassView.initializeChildComponent();
            this.childComponent = this.generateChildComponent(this.childClassView.getChildComponent());
        }
    }
    
    public JComponent generateChildComponent(JComponent component)
    {
        return component;
    }

    public JComponent getChildComponent()
    {
        return childComponent;
    }

    public ClassView getChildClassView()
    {
        return childClassView;
    }
}
