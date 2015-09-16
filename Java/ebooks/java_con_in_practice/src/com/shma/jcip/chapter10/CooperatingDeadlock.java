package com.shma.jcip.chapter10;

import java.util.HashSet;
import java.util.Set;

/**
 * 出租车调度死锁问题
 * @author admin
 *
 */
public class CooperatingDeadlock {

	class Taxi {
		private final Dispather dispather;
		
		private Point location;
		
		public Taxi(Dispather dispather) {
			this.dispather = dispather;
		}
		
		public synchronized Point getLocation() {
			return location;
		}
		
		public synchronized void setLocation(Point point, Point desc) {
			this.location = point;
			if(point.equals(desc)) {
				dispather.notifyAvailable(this);
			}
		}
	}
	
	class Dispather {
		private final Set<Taxi> taxis;
		private final Set<Taxi> availableTaxis;
		
		public Dispather() {
			taxis = new HashSet<CooperatingDeadlock.Taxi>();
			availableTaxis = new HashSet<CooperatingDeadlock.Taxi>();
		}
		
		public synchronized void notifyAvailable(Taxi taxi) {
			availableTaxis.add(taxi);
		}
		
		public synchronized Image getImage() {
			Image image = new Image();
			for(Taxi taxi : taxis) {
				image.drawMarker(taxi.getLocation());
			}
			
			return image;
		}
	}
	
	class Image {
        public void drawMarker(Point p) {
        }
    }
	
	class Point {
		
	}
}
