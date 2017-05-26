package com.itzyf;

import org.apache.commons.cli.*;

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
        int padding = 0;
        String strColor = null;
        String name = "btn_selector";

        if (args.length > 0 && args[0].startsWith("#")) {
            strColor = args[0];
        }
        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        options.addOption("h", "help", false, "帮助");
        options.addOption("p", "padding", true, "设置四个方向上的间隔值（正整数），默认无间隔");
        options.addOption("f", "filename", true, "文件的名称，默认btn_selector.xml");
        options.addOption("r", "radius", true, "圆角半径值（正整数），默认无圆角");
        options.addOption("c", "color", true, "十六进制颜色值，以#开头，如#ffffff");
        HelpFormatter hf = new HelpFormatter();
        try {
            CommandLine commandLine = parser.parse(options, args);
            if (args.length == 0 || commandLine.hasOption("h")) {
                hf.printHelp("java -jar ButtonColorGenerate.jar [color] [options]", options);
                return;
            }
            if (commandLine.hasOption("p")) {
                padding = Integer.parseInt(commandLine.getOptionValue("p"));
                System.out.println("内边距值：" + padding + "dp");
            }
            if (commandLine.hasOption("f")) {
                name = commandLine.getOptionValue("f");
            }
            if (commandLine.hasOption("r")) {
                radius = Integer.parseInt(commandLine.getOptionValue("r"));
                System.out.println("圆角半径值：" + radius + "dp");
            }
            if (commandLine.hasOption("c")) {
                strColor = commandLine.getOptionValue("c");
            }
        } catch (Exception e) {
            hf.printHelp("java -jar ButtonColorGenerate.jar [color] [options]", options);
            return;
        }

        if ("".equals(strColor)) {
            hf.printHelp("java -jar ButtonColorGenerate.jar [color] [options]", options);
            return;
        }

        System.out.println("\n颜色:");
        int color = Color.parseColor(strColor);
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

        XmlUtils.getInstance()
                .setRadius(radius)
                .setPadding(padding)
                .setFileName(name)
                .createSelector(bean);

    }

}
