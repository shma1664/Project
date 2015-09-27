package com.shma.jcip.chapter10;

import java.util.HashSet;
import java.util.Set;

public class CooperatingNoDeadlock {
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
			boolean isFinished = false;
			synchronized (this) {
				this.location = point;
				if(point.equals(desc)) {
					isFinished = true;
				}
			}
			
			if(isFinished)
				dispather.notifyAvailable(this);
		}
	}
	
	class Dispather {
		private final Set<Taxi> taxis;
		private final Set<Taxi> availableTaxis;
		
		public Dispather() {
			taxis = new HashSet<Taxi>();
			availableTaxis = new HashSet<Taxi>();
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
