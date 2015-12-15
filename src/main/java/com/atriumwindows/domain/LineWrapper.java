 package com.atriumwindows.domain;

import java.util.ArrayList;
import java.util.List;

 public class LineWrapper {

   //3 mullunit, 4 bay/bow
   private Integer lineType;

   private Line configLine;

   private List<Line> lines;

   public LineWrapper() {
     this.lines = new ArrayList<Line>();
   }

   public Integer getLineType() {
     return lineType;
   }

   public void setLineType(Integer lineType) {
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
     return "LineWrapper [lineType=" + lineType + ", configLine=" + configLine + ", lines=" + lines + "]";
   }




 }
