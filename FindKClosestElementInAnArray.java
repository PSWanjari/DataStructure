class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        //NlogN
        for(int i=0;i<arr.length;i++)
        {
            if(map.containsKey(arr[i]))
            {
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        int c=0;
        List<Integer> list = new ArrayList<Integer>();
        while(c<k)
        {
            Integer high = map.ceilingKey(x);
            Integer low = map.floorKey(x);
            if(high==null && low==null)
            {
                break;
            }
            if(high==null)
            {
                list.add(low);
                int lowcount = map.get(low);
                if(lowcount==1)
                {
                    map.remove(low);
                }else{
                    map.put(low,lowcount-1);
                }
            }else if(low==null)
            {
                list.add(high);
                int highcount = map.get(high);
                if(highcount==1)
                {
                    map.remove(high);
                }else{
                    map.put(high,highcount-1);
                }
            }else if(Math.abs(x-high)<Math.abs(x-low)){
                list.add(high);
                int highcount = map.get(high);
                if(highcount==1)
                {
                    map.remove(high);
                }else{
                    map.put(high,highcount-1);
                }
            }else{
                list.add(low);
                int lowcount = map.get(low);
                if(lowcount==1)
                {
                    map.remove(low);
                }else{
                    map.put(low,lowcount-1);
                }
            }
            c++;
        }
        //nlogn -> merge sort
        Collections.sort(list);
        return list;
    }
}
