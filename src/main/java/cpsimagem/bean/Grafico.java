package cpsimagem.bean;


import javax.annotation.ManagedBean;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

@ManagedBean
@Named(value="grafico")
public class Grafico {

		private LineChartModel model;
		public Grafico() {
		model = new LineChartModel();
		ChartSeries boys = new ChartSeries();
		boys.setLabel("Homens");
		boys.set("2004", 120);
		boys.set("2005", 100);
		boys.set("2006", 44);
		boys.set("2007", 150);
		boys.set("2008", 25);
		ChartSeries girls = new ChartSeries();
		girls.setLabel("Mulheres");
		girls.set("2004", 52);
		girls.set("2005", 60);
		girls.set("2006", 110);
		girls.set("2007", 90);
		girls.set("2008", 120);
		model.addSeries(boys);
		model.addSeries(girls);
		model.setTitle("Grafico Comparativo");
		model.setLegendPosition("e");
		model.setShowPointLabels(true);
		model.getAxes().put(AxisType.X, new CategoryAxis("Years"));
		Axis yAxis = model.getAxis(AxisType.Y);
		yAxis.setLabel("Media");
		yAxis.setMin(0);
		yAxis.setMax(200);
		}
		public LineChartModel getModel() {
		return model;
		}
		}