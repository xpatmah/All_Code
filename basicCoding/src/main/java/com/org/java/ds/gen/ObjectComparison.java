package com.org.java.ds.gen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


class Collections{
	
	public static <T extends Comparable<? super T>> T max(Collection<? extends T> list){
		Iterator<? extends T> it = list.iterator();     		
		T maxele = it.next();
		while(it.hasNext()){
			T temp = it.next();
			if(maxele.compareTo(temp)<0){
				maxele = temp;
			}
		}   
		return maxele;
	}
	
	public static <T extends Comparable<? super T>> T max(Collection<? extends T> list , Comparator<? super T> comp){
		Iterator<? extends T> it = list.iterator();     		
		T maxele = it.next();
		while(it.hasNext()){
			T temp = it.next();
			if(comp.compare(maxele,temp)<0){
				maxele = temp;
			}
		}   
		return maxele;
	}
}

class Comparisions {

	public static <T extends Comparable<? super T>> Comparator<T> naturalOrder(){
		return new Comparator<T>() {
			@Override
			public int compare(T o1, T o2) {
				return o1.compareTo(o2);
			}
		};
	} 
	
	public static <T> Comparator<List<T>> listComparator(Comparator<T> comp){
		return new Comparator<List<T>>() {
			@Override
			public int compare(List<T> o1, List<T> o2) {
				int size = o1.size();
				int size2 = o2.size();
				for(int i=0;i<Math.min(size, size2);i++){
					int result = comp.compare(o1.get(i),o2.get(i));
					if(result!=0){
						return result;
					}
				}
				return 0;
			}
		};
	}
}

public class ObjectComparison {
	
	public static void main(String[] args) {

		Suzuki suz = new Suzuki(34, 56);
		Suzuki suz2 = new Suzuki(67, 76);
		
		
		Honda h1 = new Honda(34234, 8);
		Honda h2 = new Honda(342634, 8);
		
		List<Suzuki> suziList = new ArrayList<Suzuki>();
		suziList.add(suz);
		suziList.add(suz2);
		
		List<Honda> hondaList = new ArrayList<Honda>();
		hondaList.add(h1);
		hondaList.add(h2);
		
		List<MoterCycle> moterList = new ArrayList<MoterCycle>();
		moterList.add(suz);
		moterList.add(h1);
		Collections.max(moterList);
		
		List<Car> carlist = new ArrayList<Car>();
		
		Audi a1 = new Audi(34565454,1);
		Audi a2 = new Audi(453455352,2);
		Mercedes m1 = new Mercedes(342342,5);
		carlist.add(a1);
		carlist.add(m1);
		
		List<Audi> audiList = new ArrayList<Audi>();

		Collections.max(audiList);
		
	//	Collections.max(carlist);
		
     // 	Collections.max(carlist,Comparisions.naturalOrder());
		
		System.out.println(Collections.max(suziList).racePoint);

	}

}



