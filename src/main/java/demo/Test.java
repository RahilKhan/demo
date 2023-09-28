//package example;
//
//
//import com.example.demo.designpattern.solid.Engine;
//import com.example.demo.designpattern.solid.Vehicle;
//
//import java.util.List;

/**
 * //String (Name RomanChar) eg (Jack V, Jack IV, Jackson VIII, Jack I, Jackson V)
 * Output would be  Jack I, Jack IV, Jack V, Jackson V, Jackson VIII)
 * List<String> function(List<String> list) {
 *
 *
 * }
 */

//public class Test {
//
//
//
//  public static List<String> function(List<String> list) {
//    list.stream().sorted().toList();
//    //Jack I, Jack IV, Jack V, Jackson V, Jackson VIII
//
////      Step2
////      Jack -> Jack I, Jack IV, Jack V
////      Jackson -> Jackson V, Jackson VIII
//
//
//      /*Step 1.
//      loop -> list
//           use regularExp to get name -> Jack, Jackson  [^Name $]
//           Create Map ->
//                 Jack -> I, IV, V
//                 Jackson -> V, VIII
//                 Rahul -> X, L
//      */
//
//      /*
//      Step2:
//      1. loop -> map
//            romanSorting(romanCharList);
//      2. loop -> map
//               loop -> value
//                    list.add(key + "" + value[i]
//
//      */
//
//      return romanSorting(romanCharList);
//  }
//
//    public static List<String> romanSorting(List<String> list) {
//        //sort romanchar
//
//        return list;
//    }
//
//
//    Inf Vehicle
//      topspeed()
//
//    Inf Engine
//      mileage()
//      engine()
//
//    PetrolCar implements Vehicle, Engine
//
//    ElexCar implements Vehicle
//
//
//
//
//}
