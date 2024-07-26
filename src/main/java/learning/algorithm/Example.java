package learning.algorithm;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Существует справки прописки и выписки по месту жительства. Справка состоит из полей (documentId, personId, logicalId, type).
 * Справка прописки по месту жительства имеет тип 3. Справка выбытия с места жительства имеет тип 11.
 * Справка выбытия соответственно отменяет справку прибытия, если у нее personId и logicalId совпадают друг с другом.
 * На вход метода передается набор справок и набор documentId для фильтрации выходных данных.
 * Метод должен выдавать только активные места регистрации для переданных documentId.
 * <p>
 * Пример передаваемых данных
 * Список справок:
 * (1, 1, 1, 3), (2,1,1,11), (3, 1, 2, 3) (4, 2, 1, 3) (5, 3, 1, 3)
 * (1, 1, 1, 3), (2,1,1,11), (3, 1, 2, 3)  (5, 3, 1, 3)
 * Список documentId: 1,2,3,5
 * На выходе должны получить
 * (3, 1, 2, 3) (5, 3, 1, 3)
 * <p>
 * Example 1:
 * (1, 1, 1, 3)
 * Список documentId: 1,2,3,5
 * На выходе
 * (1, 1, 1, 3)
 * <p>
 * <p>
 * <p>
 * res.
 * for( t: )
 * if( type =3)
 * var = cur;
 * for(j = i+1 )
 * if(id === && type==11){
 * var = null
 * break
 * }
 * res.put(var);
 * <p>
 * <p>
 * <p>
 * * (1, 1, 1, 3), (2,1,1,11), (3, 1, 1, 3)
 * * Список documentId: 1,2,3,5
 * * На выходе должны получить
 * * (3, 1, 1, 3)
 * * /////(1, 1, 1, 3)
 * <p>
 * *
 * * (1, 1, 1, 3), (3, 1, 1, 3), (2,1,1,11)
 * * Список documentId: 1,2,3,5
 * * На выходе должны получить
 * * (3, 1, 1, 3)
 * * /////(1, 1, 1, 3)
 */
public class Example {
    public static void main(String[] args) {
        List<Document> documents = initDocuments();
        List<Long> documentIds = List.of(1L, 2L, 3L, 5L);
        Set<Document> result = findActiveRegistrations(documents, documentIds);

        System.out.println(result);
        /**
         *
         */
//        Map db = new HashMap()
    }

    /**
     * (1, 1, 1, 3), (2,1,1,11), (3, 1, 2, 3) (4, 2, 1, 3) (5, 3, 1, 3)
     *
     * @return
     */
    private static List<Document> initDocuments() {
        DocumentType input = DocumentType.INPUT;
//        return List.of(new Document(1L, 1L, 1L, input));
        return List.of(
                new Document(1L, 1L, 1L, input),
                new Document(2L, 1L, 1L, DocumentType.OUT),
                new Document(3L, 1L, 2L, input),
                new Document(4L, 2L, 1L, input),
                new Document(5L, 3L, 1L, input),
                new Document(6L, 1L, 2L, input),
                new Document(7L, 1L, 2L, input),
                new Document(8L, 1L, 2L, DocumentType.OUT)
        );
    }


    /**
     *      * *      for documents
     *      * *          if(type==3)
     *      * *              get( cur +1)
     *      * *          else cur-1
     * @param documents
     * @param documentIds
     * @return
     */

    /**
     * Stack
     * Queue
     * <p>
     * 3 - pop. delete
     * 5
     * 7
     * <p>
     * <String, Queue<Document>
     * if put
     * else delete d
     * </Document>
     *
     * @param documents
     * @param documentIds
     * @return
     */
    private static Set<Document> findActiveRegistrations(List<Document> documents, List<Long> documentIds) {
        Map<String, Pair<Integer, Document>> store = new HashMap<>();
        for (Document document : documents) {
            String key = document.personId + ":" + document.logicalId;
            if (!store.containsKey(key)) {
                store.put(key, Pair.of(1, document));
            } else {
                Integer counter = store.get(key).getLeft();
                Document lastDocument = store.get(key).getRight();
                if (document.type == DocumentType.INPUT) {
                    store.put(key, Pair.of(counter + 1, document));
                } else {
                    store.put(key, Pair.of(counter - 1, lastDocument));
                }
            }
        }
        return store.entrySet().stream()
                .filter(pair -> pair.getValue().getLeft() > 0)
                .map(it -> it.getValue().getRight())
                .filter(document -> documentIds.contains(document.documentId))
                .collect(Collectors.toSet());
    }


    /**
     * *  HashMap<String, Pair<Long, LastDocument = 3</Long,>></String>>
     * *      first(Long personId;Long logicalId;)
     * *      second Int = 0;
     * <p>
     * <p>
     * <p>
     * *
     * *
     * *
     * *      filter>0
     *
     * @param documents
     * @param documentIds
     * @return
     */
}

@Data
@AllArgsConstructor
class Document {
    Long documentId;
    //unique:
    Long personId;
    Long logicalId;

    DocumentType type;
}

@AllArgsConstructor
enum DocumentType {
    OUT(11),
    INPUT(3);

    int type;

}
