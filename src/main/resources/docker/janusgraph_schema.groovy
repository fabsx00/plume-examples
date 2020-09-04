graph = JanusGraphFactory.open('/etc/opt/janusgraph/janusgraph.properties')

mgmt = graph.openManagement()
// Vertex labels
mgmt.containsVertexLabel('META_DATA') ?: mgmt.makeVertexLabel('META_DATA').make()
mgmt.containsVertexLabel('FILE') ?: mgmt.makeVertexLabel('FILE').make()
mgmt.containsVertexLabel('METHOD') ?: mgmt.makeVertexLabel('METHOD').make()
mgmt.containsVertexLabel('METHOD_PARAMETER_IN') ?: mgmt.makeVertexLabel('METHOD_PARAMETER_IN').make()
mgmt.containsVertexLabel('METHOD_RETURN') ?: mgmt.makeVertexLabel('METHOD_RETURN').make()
mgmt.containsVertexLabel('MODIFIER') ?: mgmt.makeVertexLabel('MODIFIER').make()
mgmt.containsVertexLabel('TYPE') ?: mgmt.makeVertexLabel('TYPE').make()
mgmt.containsVertexLabel('TYPE_DECL') ?: mgmt.makeVertexLabel('TYPE_DECL').make()
mgmt.containsVertexLabel('BINDING') ?: mgmt.makeVertexLabel('BINDING').make()
mgmt.containsVertexLabel('TYPE_PARAMETER') ?: mgmt.makeVertexLabel('TYPE_PARAMETER').make()
mgmt.containsVertexLabel('TYPE_ARGUMENT') ?: mgmt.makeVertexLabel('TYPE_ARGUMENT').make()
mgmt.containsVertexLabel('MEMBER') ?: mgmt.makeVertexLabel('MEMBER').make()
mgmt.containsVertexLabel('NAMESPACE_BLOCK') ?: mgmt.makeVertexLabel('NAMESPACE_BLOCK').make()
mgmt.containsVertexLabel('LITERAL') ?: mgmt.makeVertexLabel('LITERAL').make()
mgmt.containsVertexLabel('CALL') ?: mgmt.makeVertexLabel('CALL').make()
mgmt.containsVertexLabel('LOCAL') ?: mgmt.makeVertexLabel('LOCAL').make()
mgmt.containsVertexLabel('IDENTIFIER') ?: mgmt.makeVertexLabel('IDENTIFIER').make()
mgmt.containsVertexLabel('FIELD_IDENTIFIER') ?: mgmt.makeVertexLabel('FIELD_IDENTIFIER').make()
mgmt.containsVertexLabel('RETURN') ?: mgmt.makeVertexLabel('RETURN').make()
mgmt.containsVertexLabel('BLOCK') ?: mgmt.makeVertexLabel('BLOCK').make()
mgmt.containsVertexLabel('ARRAY_INITIALIZER') ?: mgmt.makeVertexLabel('ARRAY_INITIALIZER').make()
mgmt.containsVertexLabel('METHOD_REF') ?: mgmt.makeVertexLabel('METHOD_REF').make()
mgmt.containsVertexLabel('CONTROL_STRUCTURE') ?: mgmt.makeVertexLabel('CONTROL_STRUCTURE').make()
mgmt.containsVertexLabel('JUMP_TARGET') ?: mgmt.makeVertexLabel('JUMP_TARGET').make()
mgmt.containsVertexLabel('UNKNOWN') ?: mgmt.makeVertexLabel('UNKNOWN').make()
// Edge labels
mgmt.containsEdgeLabel('AST') ?: mgmt.makeEdgeLabel('AST').make()
mgmt.containsEdgeLabel('CFG') ?: mgmt.makeEdgeLabel('CFG').make()
mgmt.containsEdgeLabel('CONDITION') ?: mgmt.makeEdgeLabel('CONTAINS_NODE').make()
mgmt.containsEdgeLabel('CONTAINS_NODE') ?: mgmt.makeEdgeLabel('CONTAINS_NODE').make()
mgmt.containsEdgeLabel('CAPTURED_BY') ?: mgmt.makeEdgeLabel('CAPTURED_BY').make()
mgmt.containsEdgeLabel('REF') ?: mgmt.makeEdgeLabel('REF').make()
mgmt.containsEdgeLabel('BINDS_TO') ?: mgmt.makeEdgeLabel('BINDS_TO').make()
// Properties
mgmt.containsPropertyKey('signature') ?: mgmt.makePropertyKey('signature').dataType(String.class).cardinality(Cardinality.SINGLE).make()
mgmt.containsPropertyKey('evaluationStrategy') ?: mgmt.makePropertyKey('evaluationStrategy').dataType(String.class).cardinality(Cardinality.SINGLE).make()
mgmt.containsPropertyKey('name') ?: mgmt.makePropertyKey('name').dataType(String.class).cardinality(Cardinality.SINGLE).make()
mgmt.containsPropertyKey('version') ?: mgmt.makePropertyKey('version').dataType(String.class).cardinality(Cardinality.SINGLE).make()
mgmt.containsPropertyKey('language') ?: mgmt.makePropertyKey('language').dataType(String.class).cardinality(Cardinality.SINGLE).make()
mgmt.containsPropertyKey('methodInstFullName') ?: mgmt.makePropertyKey('methodInstFullName').dataType(String.class).cardinality(Cardinality.SINGLE).make()
mgmt.containsPropertyKey('argumentIndex') ?: mgmt.makePropertyKey('argumentIndex').dataType(Integer.class).cardinality(Cardinality.SINGLE).make()
mgmt.containsPropertyKey('lineNumber') ?: mgmt.makePropertyKey('lineNumber').dataType(Integer.class).cardinality(Cardinality.SINGLE).make()
mgmt.containsPropertyKey('fullName') ?: mgmt.makePropertyKey('fullName').dataType(String.class).cardinality(Cardinality.SINGLE).make()
mgmt.containsPropertyKey('order') ?: mgmt.makePropertyKey('order').dataType(Integer.class).cardinality(Cardinality.SINGLE).make()
mgmt.containsPropertyKey('canonicalName') ?: mgmt.makePropertyKey('canonicalName').dataType(String.class).cardinality(Cardinality.SINGLE).make()
mgmt.containsPropertyKey('dispatchType') ?: mgmt.makePropertyKey('dispatchType').dataType(String.class).cardinality(Cardinality.SINGLE).make()
mgmt.containsPropertyKey('code') ?: mgmt.makePropertyKey('code').dataType(String.class).cardinality(Cardinality.SINGLE).make()
mgmt.containsPropertyKey('typeFullName') ?: mgmt.makePropertyKey('typeFullName').dataType(String.class).cardinality(Cardinality.SINGLE).make()
mgmt.containsPropertyKey('methodFullName') ?: mgmt.makePropertyKey('methodFullName').dataType(String.class).cardinality(Cardinality.SINGLE).make()
mgmt.containsPropertyKey('typeDeclFullName') ?: mgmt.makePropertyKey('typeDeclFullName').dataType(String.class).cardinality(Cardinality.SINGLE).make()
// Indexes
mgmt.getGraphIndex("byASTOrder") != null ?: mgmt.buildIndex("byASTOrder", Vertex.class).addKey(mgmt.getPropertyKey("order")).buildCompositeIndex()
mgmt.getGraphIndex("byName") != null ?: mgmt.buildIndex("byName", Vertex.class).addKey(mgmt.getPropertyKey("name")).buildCompositeIndex()
mgmt.getGraphIndex("byFullName") != null ?: mgmt.buildIndex("byFullName", Vertex.class).addKey(mgmt.getPropertyKey("fullName")).buildCompositeIndex()
mgmt.getGraphIndex("bySignature") != null ?: mgmt.buildIndex("bySignature", Vertex.class).addKey(mgmt.getPropertyKey("signature")).buildCompositeIndex()

mgmt.commit()