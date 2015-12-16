 package com.atriumwindows.domain;

import java.util.ArrayList;
import java.util.List;

 public class LineWrapper {

   //3 mullunit, 4 bay/bow
   private int lineType;

   private Line configLine;

   private List<Line> lines;

   public LineWrapper() {
     this.lines = new ArrayList<Line>();
   }

   public int getLineType() {
     return lineType;
   }

   public void setLineType(int lineType) {
     this.lineType = lineType;
   }

   public Line getConfigLine() {
     return configLine;
   }

   public void setConfigLine(Line configLine) {
     this.configLine = configLine;
   }

   public List<Line> getLines() {
     return lines;
   }

   public void setLines(List<Line> lines) {
     this.lines = lines;
   }

   @Override
   public String toString() {
     return "LineWrapper{" +
             "lineType=" + lineType +
             ", configLine=" + configLine +
             ", lines=" + lines +
             '}';
   }
 }
