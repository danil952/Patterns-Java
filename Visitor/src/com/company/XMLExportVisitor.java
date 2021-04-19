package com.company;

public class XMLExportVisitor implements Visitor {

    public String export(Shape... args) {
        StringBuilder sb = new StringBuilder();
        for (Shape shape : args) {
            System.out.println(shape.getClass().getSimpleName());
            sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "\n");
            switch(shape.getClass().getSimpleName())
            {
                case "CompoundShape":sb.append(visit((CompoundShape) shape)).append("\n");
                    break;
                case "Dot": sb.append(visit((Dot)shape)).append("\n");
                break;
                case "Circle": sb.append(visit((Circle) shape)).append("\n");
                    break;
                case "Rectangle": sb.append(visit((Rectangle) shape)).append("\n");
                    break;
                default:
                    break;
            }
            System.out.println(sb.toString());
            sb.setLength(0);
        }
        return sb.toString();
    }



    public String visit(Dot d) {
        return "<dot>" + "\n" +
                "    <id>" + d.getId() + "</id>" + "\n" +
                "    <x>" + d.getX() + "</x>" + "\n" +
                "    <y>" + d.getY() + "</y>" + "\n" +
                "</dot>";
    }

    public String visit(Circle c) {
        return "<circle>" + "\n" +
                "    <id>" + c.getId() + "</id>" + "\n" +
                "    <x>" + c.getX() + "</x>" + "\n" +
                "    <y>" + c.getY() + "</y>" + "\n" +
                "    <radius>" + c.getRadius() + "</radius>" + "\n" +
                "</circle>";
    }

    public String visit(Rectangle r) {
        return "<rectangle>" + "\n" +
                "    <id>" + r.getId() + "</id>" + "\n" +
                "    <x>" + r.getX() + "</x>" + "\n" +
                "    <y>" + r.getY() + "</y>" + "\n" +
                "    <width>" + r.getWidth() + "</width>" + "\n" +
                "    <height>" + r.getHeight() + "</height>" + "\n" +
                "</rectangle>";
    }

    public String visit(CompoundShape cg) {
        return "<compound_graphic>" + "\n" +
                "   <id>" + cg.getId() + "</id>" + "\n" +
                _visitCompoundGraphic(cg) +
                "</compound_graphic>";
    }

    private String _visitCompoundGraphic(CompoundShape cg) {
        StringBuilder sb = new StringBuilder();
        for (Shape shape : cg.children) {
            String obj = export(shape);
            // Proper indentation for sub-objects.
            obj = "    " + obj.replace("\n", "\n    ") + "\n";
            sb.append(obj);
        }
        return sb.toString();
    }

}