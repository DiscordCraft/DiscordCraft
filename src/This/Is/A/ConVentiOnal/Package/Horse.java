import java.util.*;
public class Horse
{
  private static final String a = "105 116 039 115 032 116 105 109 101 032 116 111 032 100 117 045 100 117 045 100 117 045 100 117 045 100 117 045 100 117 101 108 033";
  public static String b(
  )
  {
    return
    Arrays
    .stream(
c(
)
)
      .mapToObj(
      d ->
      new StringBuffer(
      )
      .append(
      (char)d
      )
      .toString(
      )
      )
      .reduce(
      (d, e) ->
      d
      .concat(
      e
      )
      )
      .get(
      );
  }
  private static int[] c(
  )
  {
    return Arrays.stream(
    a
    .split(
    "\\s+"
    )
    )
    .mapToInt(
    d ->
    Integer
    .parseInt(
    d
    )
    )
    .toArray(
    );
  }
}