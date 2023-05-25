// source: query2.proto
/**
 * @fileoverview
 * @enhanceable
 * @suppress {missingRequire} reports error on implicit type usages.
 * @suppress {messageConventions} JS Compiler reports an error if a variable or
 *     field starts with 'MSG_' and isn't a translatable message.
 * @public
 */
// GENERATED CODE -- DO NOT EDIT!
/* eslint-disable */
// @ts-nocheck

var jspb = require('google-protobuf');
var goog = jspb;
var global =
    (typeof globalThis !== 'undefined' && globalThis) ||
    (typeof window !== 'undefined' && window) ||
    (typeof global !== 'undefined' && global) ||
    (typeof self !== 'undefined' && self) ||
    (function () { return this; }).call(null) ||
    Function('return this')();

goog.exportSymbol('proto.edu_cost_stat.QueryTwoRequest', null, global);
goog.exportSymbol('proto.edu_cost_stat.QueryTwoResponse', null, global);
goog.exportSymbol('proto.edu_cost_stat.QueryTwoResponse.StateExpensePair', null, global);
/**
 * Generated by JsPbCodeGenerator.
 * @param {Array=} opt_data Optional initial data array, typically from a
 * server response, or constructed directly in Javascript. The array is used
 * in place and becomes part of the constructed object. It is not cloned.
 * If no data is provided, the constructed object will be empty, but still
 * valid.
 * @extends {jspb.Message}
 * @constructor
 */
proto.edu_cost_stat.QueryTwoRequest = function(opt_data) {
  jspb.Message.initialize(this, opt_data, 0, -1, null, null);
};
goog.inherits(proto.edu_cost_stat.QueryTwoRequest, jspb.Message);
if (goog.DEBUG && !COMPILED) {
  /**
   * @public
   * @override
   */
  proto.edu_cost_stat.QueryTwoRequest.displayName = 'proto.edu_cost_stat.QueryTwoRequest';
}
/**
 * Generated by JsPbCodeGenerator.
 * @param {Array=} opt_data Optional initial data array, typically from a
 * server response, or constructed directly in Javascript. The array is used
 * in place and becomes part of the constructed object. It is not cloned.
 * If no data is provided, the constructed object will be empty, but still
 * valid.
 * @extends {jspb.Message}
 * @constructor
 */
proto.edu_cost_stat.QueryTwoResponse = function(opt_data) {
  jspb.Message.initialize(this, opt_data, 0, -1, proto.edu_cost_stat.QueryTwoResponse.repeatedFields_, null);
};
goog.inherits(proto.edu_cost_stat.QueryTwoResponse, jspb.Message);
if (goog.DEBUG && !COMPILED) {
  /**
   * @public
   * @override
   */
  proto.edu_cost_stat.QueryTwoResponse.displayName = 'proto.edu_cost_stat.QueryTwoResponse';
}
/**
 * Generated by JsPbCodeGenerator.
 * @param {Array=} opt_data Optional initial data array, typically from a
 * server response, or constructed directly in Javascript. The array is used
 * in place and becomes part of the constructed object. It is not cloned.
 * If no data is provided, the constructed object will be empty, but still
 * valid.
 * @extends {jspb.Message}
 * @constructor
 */
proto.edu_cost_stat.QueryTwoResponse.StateExpensePair = function(opt_data) {
  jspb.Message.initialize(this, opt_data, 0, -1, null, null);
};
goog.inherits(proto.edu_cost_stat.QueryTwoResponse.StateExpensePair, jspb.Message);
if (goog.DEBUG && !COMPILED) {
  /**
   * @public
   * @override
   */
  proto.edu_cost_stat.QueryTwoResponse.StateExpensePair.displayName = 'proto.edu_cost_stat.QueryTwoResponse.StateExpensePair';
}



if (jspb.Message.GENERATE_TO_OBJECT) {
/**
 * Creates an object representation of this proto.
 * Field names that are reserved in JavaScript and will be renamed to pb_name.
 * Optional fields that are not set will be set to undefined.
 * To access a reserved field use, foo.pb_<name>, eg, foo.pb_default.
 * For the list of reserved names please see:
 *     net/proto2/compiler/js/internal/generator.cc#kKeyword.
 * @param {boolean=} opt_includeInstance Deprecated. whether to include the
 *     JSPB instance for transitional soy proto support:
 *     http://goto/soy-param-migration
 * @return {!Object}
 */
proto.edu_cost_stat.QueryTwoRequest.prototype.toObject = function(opt_includeInstance) {
  return proto.edu_cost_stat.QueryTwoRequest.toObject(opt_includeInstance, this);
};


/**
 * Static version of the {@see toObject} method.
 * @param {boolean|undefined} includeInstance Deprecated. Whether to include
 *     the JSPB instance for transitional soy proto support:
 *     http://goto/soy-param-migration
 * @param {!proto.edu_cost_stat.QueryTwoRequest} msg The msg instance to transform.
 * @return {!Object}
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.edu_cost_stat.QueryTwoRequest.toObject = function(includeInstance, msg) {
  var f, obj = {
    year: jspb.Message.getFieldWithDefault(msg, 1, 0),
    type: jspb.Message.getFieldWithDefault(msg, 2, ""),
    length: jspb.Message.getFieldWithDefault(msg, 3, "")
  };

  if (includeInstance) {
    obj.$jspbMessageInstance = msg;
  }
  return obj;
};
}


/**
 * Deserializes binary data (in protobuf wire format).
 * @param {jspb.ByteSource} bytes The bytes to deserialize.
 * @return {!proto.edu_cost_stat.QueryTwoRequest}
 */
proto.edu_cost_stat.QueryTwoRequest.deserializeBinary = function(bytes) {
  var reader = new jspb.BinaryReader(bytes);
  var msg = new proto.edu_cost_stat.QueryTwoRequest;
  return proto.edu_cost_stat.QueryTwoRequest.deserializeBinaryFromReader(msg, reader);
};


/**
 * Deserializes binary data (in protobuf wire format) from the
 * given reader into the given message object.
 * @param {!proto.edu_cost_stat.QueryTwoRequest} msg The message object to deserialize into.
 * @param {!jspb.BinaryReader} reader The BinaryReader to use.
 * @return {!proto.edu_cost_stat.QueryTwoRequest}
 */
proto.edu_cost_stat.QueryTwoRequest.deserializeBinaryFromReader = function(msg, reader) {
  while (reader.nextField()) {
    if (reader.isEndGroup()) {
      break;
    }
    var field = reader.getFieldNumber();
    switch (field) {
    case 1:
      var value = /** @type {number} */ (reader.readInt32());
      msg.setYear(value);
      break;
    case 2:
      var value = /** @type {string} */ (reader.readString());
      msg.setType(value);
      break;
    case 3:
      var value = /** @type {string} */ (reader.readString());
      msg.setLength(value);
      break;
    default:
      reader.skipField();
      break;
    }
  }
  return msg;
};


/**
 * Serializes the message to binary data (in protobuf wire format).
 * @return {!Uint8Array}
 */
proto.edu_cost_stat.QueryTwoRequest.prototype.serializeBinary = function() {
  var writer = new jspb.BinaryWriter();
  proto.edu_cost_stat.QueryTwoRequest.serializeBinaryToWriter(this, writer);
  return writer.getResultBuffer();
};


/**
 * Serializes the given message to binary data (in protobuf wire
 * format), writing to the given BinaryWriter.
 * @param {!proto.edu_cost_stat.QueryTwoRequest} message
 * @param {!jspb.BinaryWriter} writer
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.edu_cost_stat.QueryTwoRequest.serializeBinaryToWriter = function(message, writer) {
  var f = undefined;
  f = message.getYear();
  if (f !== 0) {
    writer.writeInt32(
      1,
      f
    );
  }
  f = message.getType();
  if (f.length > 0) {
    writer.writeString(
      2,
      f
    );
  }
  f = message.getLength();
  if (f.length > 0) {
    writer.writeString(
      3,
      f
    );
  }
};


/**
 * optional int32 year = 1;
 * @return {number}
 */
proto.edu_cost_stat.QueryTwoRequest.prototype.getYear = function() {
  return /** @type {number} */ (jspb.Message.getFieldWithDefault(this, 1, 0));
};


/**
 * @param {number} value
 * @return {!proto.edu_cost_stat.QueryTwoRequest} returns this
 */
proto.edu_cost_stat.QueryTwoRequest.prototype.setYear = function(value) {
  return jspb.Message.setProto3IntField(this, 1, value);
};


/**
 * optional string type = 2;
 * @return {string}
 */
proto.edu_cost_stat.QueryTwoRequest.prototype.getType = function() {
  return /** @type {string} */ (jspb.Message.getFieldWithDefault(this, 2, ""));
};


/**
 * @param {string} value
 * @return {!proto.edu_cost_stat.QueryTwoRequest} returns this
 */
proto.edu_cost_stat.QueryTwoRequest.prototype.setType = function(value) {
  return jspb.Message.setProto3StringField(this, 2, value);
};


/**
 * optional string length = 3;
 * @return {string}
 */
proto.edu_cost_stat.QueryTwoRequest.prototype.getLength = function() {
  return /** @type {string} */ (jspb.Message.getFieldWithDefault(this, 3, ""));
};


/**
 * @param {string} value
 * @return {!proto.edu_cost_stat.QueryTwoRequest} returns this
 */
proto.edu_cost_stat.QueryTwoRequest.prototype.setLength = function(value) {
  return jspb.Message.setProto3StringField(this, 3, value);
};



/**
 * List of repeated fields within this message type.
 * @private {!Array<number>}
 * @const
 */
proto.edu_cost_stat.QueryTwoResponse.repeatedFields_ = [1];



if (jspb.Message.GENERATE_TO_OBJECT) {
/**
 * Creates an object representation of this proto.
 * Field names that are reserved in JavaScript and will be renamed to pb_name.
 * Optional fields that are not set will be set to undefined.
 * To access a reserved field use, foo.pb_<name>, eg, foo.pb_default.
 * For the list of reserved names please see:
 *     net/proto2/compiler/js/internal/generator.cc#kKeyword.
 * @param {boolean=} opt_includeInstance Deprecated. whether to include the
 *     JSPB instance for transitional soy proto support:
 *     http://goto/soy-param-migration
 * @return {!Object}
 */
proto.edu_cost_stat.QueryTwoResponse.prototype.toObject = function(opt_includeInstance) {
  return proto.edu_cost_stat.QueryTwoResponse.toObject(opt_includeInstance, this);
};


/**
 * Static version of the {@see toObject} method.
 * @param {boolean|undefined} includeInstance Deprecated. Whether to include
 *     the JSPB instance for transitional soy proto support:
 *     http://goto/soy-param-migration
 * @param {!proto.edu_cost_stat.QueryTwoResponse} msg The msg instance to transform.
 * @return {!Object}
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.edu_cost_stat.QueryTwoResponse.toObject = function(includeInstance, msg) {
  var f, obj = {
    stateExpensePairsList: jspb.Message.toObjectList(msg.getStateExpensePairsList(),
    proto.edu_cost_stat.QueryTwoResponse.StateExpensePair.toObject, includeInstance)
  };

  if (includeInstance) {
    obj.$jspbMessageInstance = msg;
  }
  return obj;
};
}


/**
 * Deserializes binary data (in protobuf wire format).
 * @param {jspb.ByteSource} bytes The bytes to deserialize.
 * @return {!proto.edu_cost_stat.QueryTwoResponse}
 */
proto.edu_cost_stat.QueryTwoResponse.deserializeBinary = function(bytes) {
  var reader = new jspb.BinaryReader(bytes);
  var msg = new proto.edu_cost_stat.QueryTwoResponse;
  return proto.edu_cost_stat.QueryTwoResponse.deserializeBinaryFromReader(msg, reader);
};


/**
 * Deserializes binary data (in protobuf wire format) from the
 * given reader into the given message object.
 * @param {!proto.edu_cost_stat.QueryTwoResponse} msg The message object to deserialize into.
 * @param {!jspb.BinaryReader} reader The BinaryReader to use.
 * @return {!proto.edu_cost_stat.QueryTwoResponse}
 */
proto.edu_cost_stat.QueryTwoResponse.deserializeBinaryFromReader = function(msg, reader) {
  while (reader.nextField()) {
    if (reader.isEndGroup()) {
      break;
    }
    var field = reader.getFieldNumber();
    switch (field) {
    case 1:
      var value = new proto.edu_cost_stat.QueryTwoResponse.StateExpensePair;
      reader.readMessage(value,proto.edu_cost_stat.QueryTwoResponse.StateExpensePair.deserializeBinaryFromReader);
      msg.addStateExpensePairs(value);
      break;
    default:
      reader.skipField();
      break;
    }
  }
  return msg;
};


/**
 * Serializes the message to binary data (in protobuf wire format).
 * @return {!Uint8Array}
 */
proto.edu_cost_stat.QueryTwoResponse.prototype.serializeBinary = function() {
  var writer = new jspb.BinaryWriter();
  proto.edu_cost_stat.QueryTwoResponse.serializeBinaryToWriter(this, writer);
  return writer.getResultBuffer();
};


/**
 * Serializes the given message to binary data (in protobuf wire
 * format), writing to the given BinaryWriter.
 * @param {!proto.edu_cost_stat.QueryTwoResponse} message
 * @param {!jspb.BinaryWriter} writer
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.edu_cost_stat.QueryTwoResponse.serializeBinaryToWriter = function(message, writer) {
  var f = undefined;
  f = message.getStateExpensePairsList();
  if (f.length > 0) {
    writer.writeRepeatedMessage(
      1,
      f,
      proto.edu_cost_stat.QueryTwoResponse.StateExpensePair.serializeBinaryToWriter
    );
  }
};





if (jspb.Message.GENERATE_TO_OBJECT) {
/**
 * Creates an object representation of this proto.
 * Field names that are reserved in JavaScript and will be renamed to pb_name.
 * Optional fields that are not set will be set to undefined.
 * To access a reserved field use, foo.pb_<name>, eg, foo.pb_default.
 * For the list of reserved names please see:
 *     net/proto2/compiler/js/internal/generator.cc#kKeyword.
 * @param {boolean=} opt_includeInstance Deprecated. whether to include the
 *     JSPB instance for transitional soy proto support:
 *     http://goto/soy-param-migration
 * @return {!Object}
 */
proto.edu_cost_stat.QueryTwoResponse.StateExpensePair.prototype.toObject = function(opt_includeInstance) {
  return proto.edu_cost_stat.QueryTwoResponse.StateExpensePair.toObject(opt_includeInstance, this);
};


/**
 * Static version of the {@see toObject} method.
 * @param {boolean|undefined} includeInstance Deprecated. Whether to include
 *     the JSPB instance for transitional soy proto support:
 *     http://goto/soy-param-migration
 * @param {!proto.edu_cost_stat.QueryTwoResponse.StateExpensePair} msg The msg instance to transform.
 * @return {!Object}
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.edu_cost_stat.QueryTwoResponse.StateExpensePair.toObject = function(includeInstance, msg) {
  var f, obj = {
    state: jspb.Message.getFieldWithDefault(msg, 1, ""),
    expense: jspb.Message.getFloatingPointFieldWithDefault(msg, 2, 0.0)
  };

  if (includeInstance) {
    obj.$jspbMessageInstance = msg;
  }
  return obj;
};
}


/**
 * Deserializes binary data (in protobuf wire format).
 * @param {jspb.ByteSource} bytes The bytes to deserialize.
 * @return {!proto.edu_cost_stat.QueryTwoResponse.StateExpensePair}
 */
proto.edu_cost_stat.QueryTwoResponse.StateExpensePair.deserializeBinary = function(bytes) {
  var reader = new jspb.BinaryReader(bytes);
  var msg = new proto.edu_cost_stat.QueryTwoResponse.StateExpensePair;
  return proto.edu_cost_stat.QueryTwoResponse.StateExpensePair.deserializeBinaryFromReader(msg, reader);
};


/**
 * Deserializes binary data (in protobuf wire format) from the
 * given reader into the given message object.
 * @param {!proto.edu_cost_stat.QueryTwoResponse.StateExpensePair} msg The message object to deserialize into.
 * @param {!jspb.BinaryReader} reader The BinaryReader to use.
 * @return {!proto.edu_cost_stat.QueryTwoResponse.StateExpensePair}
 */
proto.edu_cost_stat.QueryTwoResponse.StateExpensePair.deserializeBinaryFromReader = function(msg, reader) {
  while (reader.nextField()) {
    if (reader.isEndGroup()) {
      break;
    }
    var field = reader.getFieldNumber();
    switch (field) {
    case 1:
      var value = /** @type {string} */ (reader.readString());
      msg.setState(value);
      break;
    case 2:
      var value = /** @type {number} */ (reader.readDouble());
      msg.setExpense(value);
      break;
    default:
      reader.skipField();
      break;
    }
  }
  return msg;
};


/**
 * Serializes the message to binary data (in protobuf wire format).
 * @return {!Uint8Array}
 */
proto.edu_cost_stat.QueryTwoResponse.StateExpensePair.prototype.serializeBinary = function() {
  var writer = new jspb.BinaryWriter();
  proto.edu_cost_stat.QueryTwoResponse.StateExpensePair.serializeBinaryToWriter(this, writer);
  return writer.getResultBuffer();
};


/**
 * Serializes the given message to binary data (in protobuf wire
 * format), writing to the given BinaryWriter.
 * @param {!proto.edu_cost_stat.QueryTwoResponse.StateExpensePair} message
 * @param {!jspb.BinaryWriter} writer
 * @suppress {unusedLocalVariables} f is only used for nested messages
 */
proto.edu_cost_stat.QueryTwoResponse.StateExpensePair.serializeBinaryToWriter = function(message, writer) {
  var f = undefined;
  f = message.getState();
  if (f.length > 0) {
    writer.writeString(
      1,
      f
    );
  }
  f = message.getExpense();
  if (f !== 0.0) {
    writer.writeDouble(
      2,
      f
    );
  }
};


/**
 * optional string state = 1;
 * @return {string}
 */
proto.edu_cost_stat.QueryTwoResponse.StateExpensePair.prototype.getState = function() {
  return /** @type {string} */ (jspb.Message.getFieldWithDefault(this, 1, ""));
};


/**
 * @param {string} value
 * @return {!proto.edu_cost_stat.QueryTwoResponse.StateExpensePair} returns this
 */
proto.edu_cost_stat.QueryTwoResponse.StateExpensePair.prototype.setState = function(value) {
  return jspb.Message.setProto3StringField(this, 1, value);
};


/**
 * optional double expense = 2;
 * @return {number}
 */
proto.edu_cost_stat.QueryTwoResponse.StateExpensePair.prototype.getExpense = function() {
  return /** @type {number} */ (jspb.Message.getFloatingPointFieldWithDefault(this, 2, 0.0));
};


/**
 * @param {number} value
 * @return {!proto.edu_cost_stat.QueryTwoResponse.StateExpensePair} returns this
 */
proto.edu_cost_stat.QueryTwoResponse.StateExpensePair.prototype.setExpense = function(value) {
  return jspb.Message.setProto3FloatField(this, 2, value);
};


/**
 * repeated StateExpensePair state_expense_pairs = 1;
 * @return {!Array<!proto.edu_cost_stat.QueryTwoResponse.StateExpensePair>}
 */
proto.edu_cost_stat.QueryTwoResponse.prototype.getStateExpensePairsList = function() {
  return /** @type{!Array<!proto.edu_cost_stat.QueryTwoResponse.StateExpensePair>} */ (
    jspb.Message.getRepeatedWrapperField(this, proto.edu_cost_stat.QueryTwoResponse.StateExpensePair, 1));
};


/**
 * @param {!Array<!proto.edu_cost_stat.QueryTwoResponse.StateExpensePair>} value
 * @return {!proto.edu_cost_stat.QueryTwoResponse} returns this
*/
proto.edu_cost_stat.QueryTwoResponse.prototype.setStateExpensePairsList = function(value) {
  return jspb.Message.setRepeatedWrapperField(this, 1, value);
};


/**
 * @param {!proto.edu_cost_stat.QueryTwoResponse.StateExpensePair=} opt_value
 * @param {number=} opt_index
 * @return {!proto.edu_cost_stat.QueryTwoResponse.StateExpensePair}
 */
proto.edu_cost_stat.QueryTwoResponse.prototype.addStateExpensePairs = function(opt_value, opt_index) {
  return jspb.Message.addToRepeatedWrapperField(this, 1, opt_value, proto.edu_cost_stat.QueryTwoResponse.StateExpensePair, opt_index);
};


/**
 * Clears the list making it empty but non-null.
 * @return {!proto.edu_cost_stat.QueryTwoResponse} returns this
 */
proto.edu_cost_stat.QueryTwoResponse.prototype.clearStateExpensePairsList = function() {
  return this.setStateExpensePairsList([]);
};


goog.object.extend(exports, proto.edu_cost_stat);
