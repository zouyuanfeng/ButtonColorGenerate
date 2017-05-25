package com.itzyf;

/**
 * @author 依风听雨
 * @version 创建时间：2017/5/25 11:12
 */
public class ColorMain {

    /**
     * 参数一：固定颜色值
     *
     * @param args
     */
    public static void main(String[] args) {
        int radius = 0;
        String name = "btn_selector";
        if (args.length == 0 || "-h".equals(args[0])) {
            System.out.println("usage: java -jar ButtonColorGenerate.jar [color] [options]\ncolor\t十六进制颜色值，以#开头，如#ffffff\noptions:\n -r\t圆角半径值，默认无圆角\n -n\t生成的文件名称");
            return;
        }
        if ("".equals(args[0])) {
            throw new IllegalArgumentException("Unknown color");
        }
        //其他参数校验
        if (args.length > 1 && args.length % 2 == 1) {
            for (int i = 1; i < args.length; i += 2) {
                if ("-r".equals(args[i])) {
                    try {
                        radius = Integer.parseInt(args[i + 1]);
                    } catch (NumberFormatException e) {
                        System.out.println("圆角半径值为整数值");
                        e.printStackTrace();
                        return;
                    }
                } else if ("-n".equals(args[i])) {
                    name = args[i + 1];
                }
            }
        }

        int color = Color.parseColor(args[0]);
        ColorUtils colorUtils = new ColorUtils(color);
        System.out.println("默认状态填充颜色：#" + Integer.toHexString(color));
        System.out.println("默认状态边缘颜色：#" + Integer.toHexString(colorUtils.defaultEdge()));
        System.out.println("按下状态填充颜色：#" + Integer.toHexString(colorUtils.activeFill()));
        System.out.println("按下状态边缘颜色：#" + Integer.toHexString(colorUtils.activeEdge()));
        System.out.println("禁止状态填充颜色：#" + Integer.toHexString(colorUtils.disabledFill()));
        System.out.println("禁止状态边缘颜色：#" + Integer.toHexString(colorUtils.disabledEdge()));

        SelectorBean bean = new SelectorBean();
        bean.setDefaultSolidColor(Integer.toHexString(color));
        bean.setDefaultStrokeColor(Integer.toHexString(colorUtils.defaultEdge()));
        bean.setPressedSolidColor(Integer.toHexString(colorUtils.activeFill()));
        bean.setPressedStrokeColor(Integer.toHexString(colorUtils.activeEdge()));
        bean.setDisabledSolidColor(Integer.toHexString(colorUtils.disabledFill()));
        bean.setDisabledStrokeColor(Integer.toHexString(colorUtils.disabledEdge()));

        XmlUtils.getInstance().setRadius(radius).setFileName(name).createSelector(bean);

    }
}
