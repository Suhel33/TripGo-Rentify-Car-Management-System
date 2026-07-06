package org.netbeans.lib.awtextra;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager2;
import java.util.HashMap;
import java.util.Map;

public class AbsoluteLayout implements LayoutManager2 {
    private final Map<Component, AbsoluteConstraints> constraints = new HashMap<>();

    @Override
    public void addLayoutComponent(Component comp, Object constraints) {
        if (constraints instanceof AbsoluteConstraints) {
            this.constraints.put(comp, (AbsoluteConstraints) constraints);
        } else if (constraints != null) {
            throw new IllegalArgumentException("Unsupported constraint type: " + constraints.getClass());
        }
    }

    @Override
    public Dimension maximumLayoutSize(Container target) {
        return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Override
    public float getLayoutAlignmentX(Container target) {
        return 0.5f;
    }

    @Override
    public float getLayoutAlignmentY(Container target) {
        return 0.5f;
    }

    @Override
    public void invalidateLayout(Container target) {
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        constraints.remove(comp);
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return calculateSize(parent);
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return calculateSize(parent);
    }

    @Override
    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();
        for (Component comp : parent.getComponents()) {
            AbsoluteConstraints c = constraints.get(comp);
            if (c == null) {
                comp.setBounds(0, 0, 0, 0);
                continue;
            }
            int x = c.getX() + insets.left;
            int y = c.getY() + insets.top;
            int width = c.getWidth() >= 0 ? c.getWidth() : comp.getPreferredSize().width;
            int height = c.getHeight() >= 0 ? c.getHeight() : comp.getPreferredSize().height;
            comp.setBounds(x, y, width, height);
        }
    }

    private Dimension calculateSize(Container parent) {
        int width = 0;
        int height = 0;
        for (Component comp : parent.getComponents()) {
            AbsoluteConstraints c = constraints.get(comp);
            if (c == null) {
                continue;
            }
            int compWidth = c.getWidth() >= 0 ? c.getWidth() : comp.getPreferredSize().width;
            int compHeight = c.getHeight() >= 0 ? c.getHeight() : comp.getPreferredSize().height;
            int right = c.getX() + compWidth;
            int bottom = c.getY() + compHeight;
            width = Math.max(width, right);
            height = Math.max(height, bottom);
        }
        Insets insets = parent.getInsets();
        return new Dimension(width + insets.left + insets.right, height + insets.top + insets.bottom);
    }
}
